package validating;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author liu.hua
 */
public class TryResourceCatchTest {
    public static void writeToFileZipFileContents(String zipFileName,
                                                  String outputFileName)
            throws java.io.IOException {


        java.nio.charset.Charset charset =
                java.nio.charset.StandardCharsets.US_ASCII;
        java.nio.file.Path outputFilePath =
                java.nio.file.Paths.get(outputFileName);

        // Open zip file and create output file with
        // try-with-resources statement

        try (
                java.util.zip.ZipFile zf =
                        new java.util.zip.ZipFile(zipFileName);
                java.io.BufferedWriter writer =
                        java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
        ) {
            // Enumerate each entry
            for (java.util.Enumeration entries =
                 zf.entries(); entries.hasMoreElements();) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName =
                        ((java.util.zip.ZipEntry)entries.nextElement()).getName() +
                                newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }

    @Test
    public void tryBlockExcAndCatchThrExcAndFinallyThrExc() {
        assertThatThrownBy(() -> {
                    try {
                        throw new RuntimeException("try block RuntimeException");
                    } catch (Exception e) {
                        throw new RuntimeException("catch block RuntimeException", e);
                    } finally {
                        throw new RuntimeException("finally block RuntimeException");
                    }
                })
                .isInstanceOf(RuntimeException.class)
                .hasMessage("finally block RuntimeException")
                .hasNoCause()
                .hasNoSuppressedExceptions();
        }

    @Test
    public void tryBlockThrExcFinallyThrExc(){
        throw new RuntimeException("try blcok RuntimeException");
    }

    @Test
    public void tryResourceIsnull() {
        try (CanClose canClose = null) {
            System.out.println("success:tryResourceIsnull");
        }
    }

    @Test
    public void tryBlockThrowOneException() {
        RuntimeException tryBlockException = assertThrows(RuntimeException.class, () -> {
            try (CanClose canClose = null) {
                throw new RuntimeException("try block exception");
            }

        });
        assertEquals("try block exception", tryBlockException.getMessage());
    }

    @Test
    public void tryBlockThrowOneExceptionAndResourceThrTwoExc() {
        assertThatThrownBy(() -> {
                    try (CloseThrRunTimeExc closeThrRunTimeExc = new CloseThrRunTimeExc();
                            CloseThrException closeThrException = new CloseThrException()) {
                        throw new RuntimeException("try block exception");
                    } catch (Exception e) {
                        throw e;
                    }
                })
                .isInstanceOf(RuntimeException.class)
                .hasMessage("try block exception")
                .hasNoCause()
                .satisfies(mainEx -> {
                    assertThat(mainEx.getSuppressed())
                            .hasSize(2)
                            .extracting(Throwable::getClass, Throwable::getMessage)
                            .containsExactly(
                                    tuple(Exception.class, "CloseThrException"),
                                    tuple(RuntimeException.class, "CloseThrRunTimeExc"));
                });
    }

    public class CanClose implements AutoCloseable {
        @Override
        public void close() {
        }
    }

    public class CloseThrRunTimeExc implements AutoCloseable {
        @Override
        public void close() {
            throw new RuntimeException("CloseThrRunTimeExc");
        }
    }

    public class CloseThrException implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new Exception("CloseThrException");
        }
    }
}
