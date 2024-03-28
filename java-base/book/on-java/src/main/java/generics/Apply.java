package generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lh
 */
public class Apply {
    public static <T,S extends Iterable<T>> void apply(S seq, Method m , Object... args){
        try {
            for (T t : seq) {
                m.invoke(t,args);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            // Failures are programmer errors
            throw new RuntimeException(e);
        }
    }
}
