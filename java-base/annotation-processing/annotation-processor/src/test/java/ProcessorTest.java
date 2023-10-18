import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import com.lh.annotationprocessor.AutoValueProcessor;
import org.junit.jupiter.api.Test;

import javax.tools.JavaFileObject;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.Compiler.javac;

/**
 * @author lh
 */
public class ProcessorTest {
    @Test
    public void test() {
        JavaFileObject helloWorld = JavaFileObjects.forResource("Person.java");
        Compilation compilation =
                javac()
                        .withProcessors(new AutoValueProcessor())
                        .compile(helloWorld);
        assertThat(compilation).succeeded();

    }
}
