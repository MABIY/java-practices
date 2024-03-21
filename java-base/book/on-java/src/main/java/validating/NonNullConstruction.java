package validating;


import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author lh
 */
public class NonNullConstruction {
    private Integer n;
    private String s;

    public NonNullConstruction(Integer n, String s) {
        this.n = checkNotNull(n);
        this.s = checkNotNull(s);
    }

    public static void main(String[] args) {
        NonNullConstruction nnc = new NonNullConstruction(2,"Trousers");
    }
}
