import com.google.testing.compile.Compilation;
import com.google.testing.compile.Compiler;
import com.google.testing.compile.JavaFileObjects;
import com.lh.annotationprocessor.AutoValueProcessor;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.Processor;
import javax.tools.JavaFileObject;

import java.io.IOException;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author lh
 */
public class ProcessorTest {
    Compiler compiler;

    @BeforeEach
    public void setupCompiler() throws Exception {
        Class<?> lombokAnnotationProcessor =
                getClass().getClassLoader().loadClass("lombok.launch.AnnotationProcessorHider$AnnotationProcessor");
        Class<?> lombokClaimingProcessor =
                getClass().getClassLoader().loadClass("lombok.launch.AnnotationProcessorHider$ClaimingProcessor");
        compiler = Compiler.javac()
                .withProcessors(
                        (Processor) lombokAnnotationProcessor
                                .getDeclaredConstructor()
                                .newInstance(),
                        (Processor)
                                lombokClaimingProcessor.getDeclaredConstructor().newInstance(),
                        new AutoValueProcessor());
    }

    @Test
    public void test() throws IOException {
        JavaFileObject helloWorld = JavaFileObjects.forResource("Person.java");
        Compilation compilation = compiler.compile(helloWorld);
        assertThat(compilation).succeeded();
        String actualImpl = compilation.generatedSourceFile("com.lh.test.annotationprocessor.value.PersonNEW").orElseThrow()
                .getCharContent(false).toString();

        JavaFileObject resultJavaFileObject = JavaFileObjects.forResource("result/PersonNEW.java");
        String result = resultJavaFileObject.getCharContent(false).toString();

        MatcherAssert.assertThat(actualImpl.lines().toArray(), is(result.lines().toArray()));
    }
}
