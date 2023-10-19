import com.google.testing.compile.Compilation;
import com.google.testing.compile.Compiler;
import com.google.testing.compile.JavaFileObjects;
import com.lh.annotationprocessor.AutoValueProcessor;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
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

    private static void checkResult(Compilation compilation, String generatedSourceFileName, String resourceName)
            throws IOException {
        String actualImpl = compilation
                .generatedSourceFile(generatedSourceFileName)
                .orElseThrow()
                .getCharContent(false)
                .toString();

        //        BufferedWriter writer = new BufferedWriter(new
        // FileWriter(resourceName.substring(resourceName.lastIndexOf("/")+1)));
        //        writer.write(actualImpl);
        //        writer.close();

        JavaFileObject resultJavaFileObject = JavaFileObjects.forResource(resourceName);
        String result = resultJavaFileObject.getCharContent(false).toString();
        MatcherAssert.assertThat(actualImpl.lines().toArray(), is(result.lines().toArray()));
    }

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
    @Order(1)
    public void test() throws IOException {
        JavaFileObject helloWorld = JavaFileObjects.forResource("OrderedPair.java");
        Compilation compilation = compiler.compile(helloWorld);
        assertThat(compilation).succeeded();

        checkResult(
                compilation, "com.lh.annotationprocessor.value.OrderedPairNew", "result/generic/OrderedPairNew.java");
    }

    @Test
    @Order(2)
    public void test1() throws IOException {
        JavaFileObject helloWorld = JavaFileObjects.forResource("UserAccount.java");
        Compilation compilation = compiler.compile(helloWorld);
        assertThat(compilation).succeeded();

        checkResult(
                compilation,
                "com.lh.annotationprocessor.value.UserAccountNew",
                "result/useracccount/UserAccountNew.java");
        checkResult(
                compilation,
                "com.lh.annotationprocessor.value.UserAccountSimple",
                "result/useracccount/UserAccountSimple.java");
        checkResult(
                compilation,
                "com.lh.annotationprocessor.value.UserAccountValue",
                "result/useracccount/UserAccountValue.java");
        checkResult(
                compilation,
                "com.lh.annotationprocessor.value.UserAccountResetPassword",
                "result/useracccount/UserAccountResetPassword.java");
    }
}
