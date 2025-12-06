package chapter2.practice;

/**
 * Run Documentation1.java,Documentation2.java and Documentation3.java through javadoc. Verify the
 * resulting documentation with your web browser.
 */

import java.util.Date;

/**
 * <pre>
 *     uses
 *     System.out.println(new Date())
 * </pre>
 * @author lh
 */
public class Documentation2_ch2_13 {
    Date d = new Date();
    void showDate(){
        System.out.println("Date = " + d);
    }
}
