package com.lh.annotationprocessor.base;

import com.squareup.javapoet.JavaFile;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * @author lh
 */
public abstract class BaseProcessor extends AbstractProcessor {
    protected Elements elements;
    protected Types types;
    protected Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        elements = processingEnv.getElementUtils();
        types = processingEnv.getTypeUtils();
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for(TypeElement annotation: annotations) {
            Set<? extends Element> annotatedElements =roundEnv.getElementsAnnotatedWith(annotation);
            annotatedElements.forEach(element -> process(element,roundEnv));
        }
        return  true;
    }

    protected abstract void process(Element element,RoundEnvironment roundEnv);

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

   @Override
    public Set<String> getSupportedAnnotationTypes() {
        return super.getSupportedAnnotationTypes(); //todo_lh look java module
    }

    // todo_lh  use gradle speed up
    protected void writeJavaFile(String packageName, String simpleName, JavaFile javaFileContent) {
        try {
            JavaFileObject javaFileObject = processingEnv.getFiler()
                    .createSourceFile(packageName +"." + simpleName);
            try(PrintWriter out = new PrintWriter(javaFileObject.openWriter())){
                javaFileContent.writeTo(out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
