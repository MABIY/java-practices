package generics;

import ch.qos.logback.core.hook.DefaultShutdownHook;

/**
 * @author lh
 */
public class Wildcards {
    // Raw argumetn:
    static void rawArgs(Holder holder, Object arg) {
        //          holder.set(arg);
        // warning: [unchecked] unchecked call to set(T)
        // as a member of the raw type Holder
        //
        //        holder.set(arg);
        //
        //
        //        where T is a type-variable:
        //
        //        T extends Object declared in class Holder
        // 1 warning

        // Can't do this; don't have any 'T':
        //        T t = holder.get();
        // Ok, but type information is lost
        Object obj = holder.get();
    }

    // Like rawArgs(), but errors instead of warnings:
    static void unbounedArg(Holder<?> holder, Object arg) {

        //          holder.set(arg);
        //        error: incompatible types: Object cannot be converted to CAP#1
        //        holder.set(arg);
        //                     ^
        //        where CAP#1 is a fresh type-variable:
        //        CAP#1 extends Object from capture of ?
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        return holder.get();
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        return holder.get();
    }

    static <T> T wildSubType(Holder<? extends T> holder, T arg) {
        //        holder.set(arg);
        // error: incompatible types: T cannot be converted to CAP#1
        //        holder.set(arg);
        //                   ^
        //  where T is a type-variable:
        //    T extends Object declared in method <T>wildSubType(Holder<? extends T>,T)
        //  where CAP#1 is a fresh type-variable:
        //    CAP#1 extends T from capture of ? extends T
        return holder.get();
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
        //        T t = holder.get();
        //         error: incompatible types: CAP#1 cannot be converted to T
        //        T t = holder.get();
        //                        ^
        //  where T is a type-variable:
        //    T extends Object declared in method <T>wildSupertype(Holder<? super T>,T)
        //  where CAP#1 is a fresh type-variable:
        //    CAP#1 extends Object super: T from capture of ? super T
        Object object = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<>();
        // Or:
        raw = new Holder();

        Holder<Long> qualfied = new Holder<>();
        Holder<?> unbouned = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();

        Long lng = 1L;
        rawArgs(raw, lng);
        rawArgs(qualfied, lng);
        rawArgs(unbouned, lng);
        rawArgs(bounded, lng);

        unbounedArg(raw, lng);
        unbounedArg(qualfied, lng);
        unbounedArg(unbouned, lng);
        unbounedArg(bounded, lng);

        //        Object r1 = exact1(raw);
        //        warning: [unchecked] unchecked method invocation: method exact1 in class Wildcards is applied to given
        // types
        //        Object r1 = exact1(raw);
        //                          ^
        //  required: Holder<T>
        //  found:    Holder
        //  where T is a type-variable:
        //    T extends Object declared in method <T>exact1(Holder<T>)
        // 2 warnings

        Long r2 = exact1(qualfied);
        Object r3 = exact1(unbouned); // Must return Object
        Long r4 = exact1(bounded);

        //        Long r5 = exact2(raw,lng);
        //        warning: [unchecked] unchecked method invocation: method exact2 in class Wildcards is applied to given
        // types
        //        Long r5 = exact2(raw,lng);
        //                        ^
        //  required: Holder<T>,T
        //  found:    Holder,Long
        //  where T is a type-variable:
        //    T extends Object declared in method <T>exact2(Holder<T>,T)

        // warning: [unchecked] unchecked conversion
        //        Long r5 = exact2(raw,lng);
        //                         ^
        //  required: Holder<T>
        //  found:    Holder
        //  where T is a type-variable:
        //    T extends Object declared in method <T>exact2(Holder<T>,T)
        // 2 warnings
        Long r6 = exact2(qualfied, lng);

        //                Long r7 = exact2(unbouned,lng);
        // error: method exact2 in class Wildcards cannot be applied to given types;
        //        Long r7 = exact2(unbouned,lng);
        //                  ^
        //  required: Holder<T>,T
        //  found:    Holder<CAP#1>,Long
        //  reason: inference variable T has incompatible bounds
        //    equality constraints: CAP#1
        //    lower bounds: Long
        //  where T is a type-variable:
        //    T extends Object declared in method <T>exact2(Holder<T>,T)
        //  where CAP#1 is a fresh type-variable:
        //    CAP#1 extends Object from capture of ?
        // 1 error

        //        Long r8 = exact2(bounded,lng);
        // error: method exact2 in class Wildcards cannot be applied to given types;
        //        Long r8 = exact2(bounded,lng);
        //                  ^
        //  required: Holder<T>,T
        //  found:    Holder<CAP#1>,Long
        //  reason: inference variable T has incompatible bounds
        //    equality constraints: CAP#1
        //    lower bounds: Long
        //  where T is a type-variable:
        //    T extends Object declared in method <T>exact2(Holder<T>,T)
        //  where CAP#1 is a fresh type-variable:
        //    CAP#1 extends Long from capture of ? extends Long
        // 1 error

        //        Long r9 = wildSubType(raw, lng);
        // warning: [unchecked] unchecked method invocation: method wildSubType in class Wildcards is applied to given
        // types
        //        Long r9 = wildSubType(raw,lng);
        //                             ^
        //  required: Holder<? extends T>,T
        //  found:    Holder,Long
        //  where T is a type-variable:
        //    T extends Object declared in method <T>wildSubType(Holder<? extends T>,T)

        // warning: [unchecked] unchecked conversion
        //        Long r9 = wildSubType(raw,lng);
        //                              ^
        //  required: Holder<? extends T>
        //  found:    Holder
        //  where T is a type-variable:
        //    T extends Object declared in method <T>wildSubType(Holder<? extends T>,T)
        // 2 warnings

        Long r10 = wildSubType(qualfied, lng);
        // Ok, but only return Object:
        Object r11 = wildSubType(unbouned, lng);
        Long r12 = wildSubType(bounded, lng);
        //        wildSupertype(raw,lng);
        // warning: [unchecked] unchecked method invocation: method wildSupertype in class Wildcards is applied to given
        // types
        //        wildSupertype(raw,lng);
        //                     ^
        //  required: Holder<? super T>,T
        //  found:    Holder,Long
        //  where T is a type-variable:
        //    T extends Object declared in method <T>wildSupertype(Holder<? super T>,T)
        //  warning: [unchecked] unchecked conversion
        //        wildSupertype(raw,lng);
        //                      ^
        //  required: Holder<? super T>
        //  found:    Holder
        //  where T is a type-variable:
        //    T extends Object declared in method <T>wildSupertype(Holder<? super T>,T)
        // 2 warnings

        wildSupertype(qualfied, lng);

//                wildSupertype(unbouned,lng);
        // error: method wildSupertype in class Wildcards cannot be applied to given types;
        //        wildSupertype(unbouned,lng);
        //        ^
        //  required: Holder<? super T>,T
        //  found:    Holder<CAP#1>,Long
        //  reason: inference variable T has incompatible bounds
        //    lower bounds: CAP#1,Object
        //    lower bounds: Long
        //  where T is a type-variable:
        //    T extends Object declared in method <T>wildSupertype(Holder<? super T>,T)
        //  where CAP#1 is a fresh type-variable:
        //    CAP#1 extends Object from capture of ?
        // 1 error

//        wildSupertype(bounded,lng);
        // error: method wildSupertype in class Wildcards cannot be applied to given types;
        //        wildSupertype(bounded,lng);
        //        ^
        //  required: Holder<? super T>,T
        //  found:    Holder<CAP#1>,Long
        //  reason: inference variable T has incompatible bounds
        //    lower bounds: CAP#1,Object
        //    lower bounds: Long
        //  where T is a type-variable:
        //    T extends Object declared in method <T>wildSupertype(Holder<? super T>,T)
        //  where CAP#1 is a fresh type-variable:
        //    CAP#1 extends Long from capture of ? extends Long
    }
}
