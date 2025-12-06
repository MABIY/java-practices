package chapter2.practice;

import java.nio.charset.Charset;

/**
 * Write a program that demonstrates that autoboxing works for all the primitive types and their
 * wrappers.
 *
 * @author lh
 */
public class AutoboxTest_ch2_09 {
    public static void main(String[] args) {
        boolean b = false;
        char c = 'x';
        byte t = 8;
        short s = 16;
        int i = 32;
        long l = 64;
        float f = 0.32f;
        double d = 0.32f;
        Boolean B = b;
        System.out.println("boolean b = " + b);
        System.out.println("Boolean B = " + B);
        Character C = c;
        System.out.println("char c = " + c);
        System.out.println("Character C = " + C);
        Byte T = t;
        System.out.println("byte t=  " + t);
        System.out.println("Byte T=  " + T);
        Short S = s;
        System.out.println("short s = " + s);
        System.out.println("Short S = " + S);
        Integer I = i;
        System.out.println("int i= " + i);
        System.out.println("Integer I  = " + I);
        Long L = l;
        System.out.println("long l = " + l);
        System.out.println("Long L = " + L);
        Float F = f;
        System.out.println("float f = " + f);
        System.out.println("Float F = " + F);
        Double D = d;
        System.out.println("double d = " + d);
        System.out.println("Double D = " + D);
        // wrapper to primitive
        d = D;

        System.out.println("d =D= " + d);
        f = F;

        System.out.println("f =F= " + f);
        l = L;

        System.out.println("l =L= " + l);
        i = I;

        System.out.println("i =I= " + i);
        s = S;

        System.out.println(" s= S= " + s);
        t = T;

        System.out.println("t = T= " + t);
        c = C;

        System.out.println(" c= C= " + c);
        b = B;

        System.out.println("b = B= " + b);
    }
}
