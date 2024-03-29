package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author lh
 */
public class LoggingException2 {
    private static Logger logger = Logger.getLogger("LoggingException2");
    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    public static void main(String[] args) {
        try {
            throw new NumberFormatException();
        } catch (NumberFormatException e) {
            logException(e);
        }
    }
}
