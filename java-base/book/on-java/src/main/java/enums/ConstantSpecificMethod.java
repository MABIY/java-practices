package enums;

import javax.crypto.spec.GCMParameterSpec;
import java.text.DateFormat;
import java.util.Date;

/**
 * @author lh
 */
public enum ConstantSpecificMethod {
    DATE_TIME {
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION{
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    }
    ;
    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }
}
