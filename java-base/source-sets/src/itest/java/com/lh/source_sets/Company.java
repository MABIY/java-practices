package com.lh.source_sets;

import java.lang.annotation.*;

/**
 * @author lh
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Company {
    String name() default "ABC";
    String city() default "XYZ";
}
