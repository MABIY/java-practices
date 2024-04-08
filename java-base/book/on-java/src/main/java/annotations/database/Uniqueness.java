package annotations.database;

/**
 * @author lh
 */
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
