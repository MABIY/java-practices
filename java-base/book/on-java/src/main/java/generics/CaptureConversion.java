package generics;

/**
 * @author lh
 */
public class CaptureConversion {
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }
    static void f2(Holder<?> holder){
        f1(holder); // call with captured type
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder raw = new Holder<>(1);
        f1(raw);
        //  warning: [unchecked] unchecked method invocation: method f1 in class CaptureConversion is applied to given types
        //        f1(raw);
        //          ^
        //  required: Holder<T>
        //  found:    Holder
        //  where T is a type-variable:
        //    T extends Object declared in method <T>f1(Holder<T>)
        // warning: [unchecked] unchecked conversion
        //        f1(raw);
        //           ^
        //  required: Holder<T>
        //  found:    Holder
        //  where T is a type-variable:
        //    T extends Object declared in method <T>f1(Holder<T>)
        // 2 warnings

        f2(raw);// now warning
}
}
