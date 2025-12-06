package chapter2.content.javadoc;

/**
 * A class comment
 * @author lh
 */
public class Documentation1 {
    /**
     * A field comment
     */
    public int i;

    /**
     * A method comment {@link Object#toString() string}
     *
     * @throws Exception ext
     * @throws RuntimeException e
     * @deprecated deprecated
     * @see String#toLowerCase() convertToLowercase
     */
    public void f() throws Exception{

    }


    /**
     *
     * Use {@link String#toLowerCase()} for conversion to lower case alphabets.
     * @deprecated As of Java 1.8 {@link java.security.Certificate} is deprecated.
     * @return {@link String} object
     * @see <a href="http://www.baeldung.com">Baeldung</a>
     * @see String#hashCode() hashCode
     */
    public String someMethod() {
        // perform some function
        return "";
    }

    /**
     * Some description here.
     *
     * @see java.lang.Object
     * This is a {@link #getClass() } method.
     * @see #getClass() Use {@link #toString()} for String conversion.
     * @deprecated As of JDK 1.1, replaced by {@link #someMethod()}
     */
    public void test(){

    }
}
