package com.lh.annotationprocessor;


import com.fasterxml.jackson.annotation.JsonView;
import com.google.auto.service.AutoService;
import com.lh.annotation.AutoValueDTO;
import com.lh.annotationprocessor.base.BaseProcessor;
import com.lh.annotationprocessor.utils.StringUtils;
import com.squareup.javapoet.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.MirroredTypesException;
import javax.lang.model.type.TypeMirror;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.lh.annotationprocessor.utils.StringUtils.uppercaseFirstLetter;

// todo_lh 属性注释 ， 类的泛化参数对应的属性值
@AutoService(Processor.class)
public class AutoValueProcessor extends BaseProcessor {
    public  FieldSpec convert(VariableElement fieldElement) {
        return FieldSpec.builder(
                        TypeName.get(fieldElement.asType()),
                        fieldElement.getSimpleName().toString(),
                        fieldElement.getModifiers().toArray(Modifier[]::new))
                .addAnnotations(copyAnnotations(fieldElement))
                .build();
    }

    private static void extracted(MethodSpec.Builder createMethodBuilder, FieldSpec fieldSpec) {
        createMethodBuilder.addStatement(
                "entity.set" + uppercaseFirstLetter(fieldSpec.name) + "(" + fieldSpec.name + ")");
    }

    @Override
    protected void process(Element element, RoundEnvironment roundEnv) {
        TypeElement typeElement = (TypeElement) element;
        List<AnnotationSpec> classAnnotations = copyAnnotations(typeElement);
        Stream<Map.Entry<TypeElement, Stream<Element>>> inheritedChain = inheritedChain(typeElement.asType());

        Map<String, List<GeneratedField>> generatedFieldsMap = inheritedChain
                .flatMap(typeElementStreamEntry -> typeElementStreamEntry
                        .getValue()
                        .filter(value -> value.getKind().isField())
                        .map(value -> (VariableElement) value)
                        .map(value -> new TypeElementField(typeElementStreamEntry.getKey(), value)))
                .flatMap(typeElementField -> getDtoAnnotationValueType(typeElementField.variableElement).stream()
                        .map(mirror -> new GeneratedField(mirror, typeElementField)))
                .collect(Collectors.groupingBy(GeneratedField::getGroupName));

        Map<String, List<GeneratedField>> classAndAllGenertedFieldsMap = generatedFieldsMap.keySet().stream()
                .flatMap(groupName -> generatedFieldsMap.get(groupName).stream()
                        .findFirst()
                        .map(generatedField -> inheritedChain(generatedField.group)
                                .flatMap(typeElementStreamEntry ->
                                        Optional.ofNullable(generatedFieldsMap.get(typeElementStreamEntry
                                                        .getKey()
                                                        .toString()))
                                                .stream()
                                                .flatMap(Collection::stream)
                                                .map(generatedField1 -> new GeneratedField(
                                                        generatedField.group, generatedField1.field))))
                        .orElse(Stream.empty()))
                .collect(Collectors.groupingBy(
                        generatedField -> typeElement.getEnclosingElement() + ".value." + typeElement.getSimpleName()
                                + StringUtils.getLastDelimiterValue(generatedField.getGroupName(), '.')));
        for (String classQualifedNameString : classAndAllGenertedFieldsMap.keySet()) {
            ClassName classQualifiedName = ClassName.bestGuess(classQualifedNameString);
            createJavaFile(
                    classQualifiedName.packageName(),
                    classQualifiedName.simpleName(),
                    classAnnotations,
                    classAndAllGenertedFieldsMap.get(classQualifedNameString));
        }
    }

    private  List<AnnotationSpec> copyAnnotations(Element element) {
        return elements.getAllAnnotationMirrors(element).stream()
                .map(AnnotationSpec::get)
                .filter(annotationSpec -> {
                    String canonicalClassName = annotationSpec.type.toString();
                    return !canonicalClassName.startsWith("javax.persistence.")
                            && !canonicalClassName.startsWith("lombok.")
                            && !canonicalClassName.startsWith("com.lh.annotation.")
                            && !canonicalClassName.startsWith("jakarta.persistence.")
                            && !canonicalClassName.startsWith("com.yunmo.generator.annotation.")
                            && !canonicalClassName.startsWith("org.hibernate.annotations.")
                            && !canonicalClassName.startsWith("com.fasterxml.jackson.annotation.JsonView");
                })
                .toList();
    }

    private void createJavaFile(String packageName, String classSimpleName,List<AnnotationSpec> classAnnotationSpecs ,List<GeneratedField> generatedFields) {
        ClassName className = ClassName.get(packageName, classSimpleName);
        TypeSpec.Builder classBuilder = TypeSpec.classBuilder(classSimpleName)
                .addAnnotation(Data.class)
                .addAnnotations(classAnnotationSpecs)
                .addModifiers(Modifier.PUBLIC);

        Set<FieldSpec> fieldSpecs = generatedFields.stream()
                .map(field -> convert(field.field.variableElement))
                .collect(Collectors.toSet());

        // todo_lh 过来生成类的注解
        fieldSpecs.forEach(classBuilder::addField);

        MethodSpec.Builder createMethodBuilder = MethodSpec.methodBuilder("create")
                .addModifiers(Modifier.PUBLIC)
                .returns(className)
                .addStatement("$T entity = new $T()", className, className);
        for (FieldSpec fieldSpec : fieldSpecs) {
            extracted(createMethodBuilder, fieldSpec);
        }
        createMethodBuilder.addStatement("return entity");
        classBuilder.addMethod(createMethodBuilder.build());

        MethodSpec.Builder assignMethodBuilder = MethodSpec.methodBuilder("assign")
                .addModifiers(Modifier.PUBLIC)
                .returns(className)
                .addParameter(className, "entity");
        for (FieldSpec fieldSpec : fieldSpecs) {
            assignMethodBuilder.addStatement(
                    "entity.set" + uppercaseFirstLetter(fieldSpec.name) + "(" + fieldSpec.name + ")");
        }
        assignMethodBuilder.addStatement("return entity");
        classBuilder.addMethod(assignMethodBuilder.build());

        MethodSpec.Builder patchMethodBuilder = MethodSpec.methodBuilder("patch")
                .addModifiers(Modifier.PUBLIC)
                .returns(className)
                .addParameter(className, "entity");
        for (FieldSpec fieldSpec : fieldSpecs) {
            if (fieldSpec.type.isPrimitive()) {
                patchMethodBuilder.addStatement(
                        "entity.set" + uppercaseFirstLetter(fieldSpec.name) + "(" + fieldSpec.name + ")");
            } else {
                patchMethodBuilder.beginControlFlow("if (" + fieldSpec.name + " != null )");
                patchMethodBuilder.addStatement(
                        "entity.set" + uppercaseFirstLetter(fieldSpec.name) + "(" + fieldSpec.name + ")");
                patchMethodBuilder.endControlFlow();
            }
        }
        patchMethodBuilder.addStatement("return entity");
        classBuilder.addMethod(patchMethodBuilder.build());
        JavaFile javaFile = JavaFile.builder(packageName, classBuilder.build()).build();
        writeJavaFile(packageName, classSimpleName, javaFile);
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(AutoValueDTO.class.getCanonicalName());
    }

    private Stream<Map.Entry<TypeElement, Stream<Element>>> inheritedChain(TypeMirror typeMirror) {
        if (typeMirror.toString().equals(Object.class.getCanonicalName())) {
            return Stream.empty();
        }
        Stream<Map.Entry<TypeElement, Stream<Element>>> superClassStream =
                types.directSupertypes(typeMirror).stream().flatMap(this::inheritedChain);
        Stream<Map.Entry<TypeElement, Stream<Element>>> typeVariableMapStream = Stream.of(new AbstractMap.SimpleEntry<>(
                (TypeElement) types.asElement(typeMirror),
                types.asElement(typeMirror).getEnclosedElements().stream().map(element -> element)));
        return Stream.concat(typeVariableMapStream, superClassStream);
    }

    private List<? extends TypeMirror> getDtoAnnotationValueType(VariableElement variableElement) {
        try {
            JsonView jsonView = variableElement.getAnnotation(JsonView.class);
            if (jsonView != null) {
                jsonView.value();
            } else {
                return List.of();
            }
            throw new RuntimeException("parse dto annotation value error"); // 测试错误是的单元和现象
        } catch (MirroredTypesException ex) {
            return ex.getTypeMirrors();
        }
    }

    @AllArgsConstructor
    private static class TypeElementField {
        public final TypeElement typeElement;
        public final VariableElement variableElement;
    }

    @AllArgsConstructor
    private static class GeneratedField {
        public TypeMirror group;
        public TypeElementField field;

        public String getGroupName() {
            return group.toString();
        }
    }
}