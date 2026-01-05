package chapter4.practice;

import static util.Print.print;

/**
 * Repeat exercise 10 from the last chapter using the ternary operator and a
 * bitwise test to display the ones and zeros, instead of Integer.toBinaryString()
 * @author lh
 */
public class BitTest{
    static void binaryPrint(int q){
        if(q ==0) System.out.print(0);
        else {
            int nlz = Integer.numberOfLeadingZeros(q);
            q <<= nlz;
            for(int p = 0; p < 32-nlz; p++) {
                int n = (Integer.numberOfLeadingZeros(q) == 0) ? 1 : 0;
                System.out.print(n);
                q <<= 1;
            }
        }
        System.out.println("");
    }

    public static void main(String[] args){
        int i = 1 + 4 + 16 + 64;
        int j = 2 + 8 + 32 + 128;
        int k = 0x100;
        int m = -311111111;
        print("Using Integer.toBinaryString():");
        print("i = " + Integer.toBinaryString(i));
        print("j = " + Integer.toBinaryString(j));
        print("k = " + Integer.toBinaryString(k));
        print("m = " + Integer.toBinaryString(m));
        print("i & j = " + (i & j) + " = " + Integer.toBinaryString(i & j));
        print("i | j = " + (i | j) + " = " + Integer.toBinaryString(i | j));
        print("i ^ j = " + (i ^ j) + " = " + Integer.toBinaryString(i ^ j));
        print("~i = " + Integer.toBinaryString(~i));
        print("~j = " + Integer.toBinaryString(~j));
        print("Using binaryPrint():");
        print("i = " + i +" = ");
        binaryPrint(i);
        print("j = " + j +" = ");
        binaryPrint(j);
        print("k = " + k + " = ");
        binaryPrint(k);
        print("m = " + m + " = ");
        binaryPrint(m);
        print("i & j = " + (i &j) + " = ");
        binaryPrint(i & j);
        print("i | j = " + (i |j) + " = ");
        binaryPrint(i | j);
        print("i ^ j = " + (i ^j) + " = ");
        binaryPrint(i ^ j);
        print("~i = " + ~i + " = ");
        binaryPrint(~i);
        print("~j = " + ~j + " = ");
        binaryPrint(~j);
    }
}
