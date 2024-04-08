package annotations.simplest;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * @author lh
 */
@SupportedAnnotationTypes("annotations.simplest.Simple")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class SimpleProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement t : annotations) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, t.toString());
        }
        for (Element element : roundEnv.getElementsAnnotatedWith(Simple.class)) {
            display(element);
        }
        return false;
    }

    private void display(Element el) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,"==== " + el + " ===");
        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,el.getKind()+
                " : "  + el.getModifiers() +
                " : "  + el.getSimpleName() +
                " : "  + el.asType()
        );
        if(el.getKind().equals(ElementKind.CLASS)) {
            TypeElement te = (TypeElement)el;
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,te.getQualifiedName());
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,te.getSuperclass().toString());
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,te.getEnclosedElements().toString());
        }
        if(el.getKind().equals(ElementKind.METHOD)) {
            ExecutableElement ex = (ExecutableElement) el;
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,ex.getReturnType() + " ");
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,ex.getSimpleName() + "(");
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,ex.getParameters() + ")");
        }
    }
}
