package chapter4;

import static util.Print.print;
import static util.Print.printnb;
import static util.Range.range;

/**
 * @author lh
 */
public class ForEachInt {
    public static void main(String[] args){
        for(int i : range(10)) {
            printnb(i +" ");
        }
        print();
        for(int i: range(5,10)){
            printnb(i + " ");
        }
        print();
        for(int i : range(5,20,3)){
            printnb(i  + " ");
        }
        print();
    }
}

