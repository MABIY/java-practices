package util;

/**
 * Array creation methods that can be used without
 * qualifiers, using java SE5 static imports.
 * @author lh
 */
public class Range {
    //Produce a sequence [10..n)
    public static int[] range(int n){
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            result[i] = i;
        }
        return result;
    }
    // Produce a sequence [start...end)
    public static int[] range(int start,int end){
        int sz = end - start;
        int[] result = new int[sz];
        for(int i = 0; i < sz; i++) {
            result[i] = start +i;
        }
        return result;
    }

    public static int[] range(int start,int end,int step){
        int sz = (end - start) / step;
        int[] result = new int[sz];
        for(int i = 0; i < sz; i++) {
            result[i] = start + (i * step);
        }
        return result;
    }

}
