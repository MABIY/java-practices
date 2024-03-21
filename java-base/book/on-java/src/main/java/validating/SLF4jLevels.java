package validating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lh
 */
public class SLF4jLevels {
    private static Logger log = LoggerFactory.getLogger(SLF4jLevels.class);

    public static void main(String[] args) {
        log.trace("Hello");
        log.debug("Logging");
        log.info("Using");
        log.warn("the SLF4J");
        log.error("Facade");
    }
}
