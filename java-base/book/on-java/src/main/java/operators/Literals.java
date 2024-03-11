package operators;

/**
 * @author lh
 */
public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f; // 16 进制 （小写）
        System.out.println(
                "i1: " + Integer.toBinaryString(i1)
        );
        int i2 = 0x2f;
        System.out.println(
                "i2: " + Integer.toBinaryString(i2)
        );
        int i3 = 0177;
        System.out.println(
                "i3: " + Integer.toBinaryString(i3)
        );
        char c = 0xffff;//最大 char 型  16 进制值
        System.out.println(
                "c: " + Integer.toBinaryString(c)
        );

        byte b = 0x7f; // 最大byte型 16进制值 01111111;
        System.out.println(
                "b: " + Integer.toBinaryString(b)
        );
        short s = 0x7fff;
        System.out.println(
                "s: " + Integer.toBinaryString(s)
        );

        long n1 = 200L; //long 型后缀
        long n2 = 300l; //long 型后缀 (容易与数值1混淆)
        long n3 =300;
        byte blb = (byte)0b11111111;
        System.out.println(
                "blb: " + Integer.toBinaryString(blb)
        );
        short bls = 0B0010111110101111;
        System.out.println(
                "bls: " +Integer.toBinaryString(bls)
        );
        int bli = 0b00101111101011111010111110101111;
        System.out.println(
                "bli: " +Integer.toBinaryString(bli)
        );
        long bll = 0b001011111010111110101111101101111;
        System.out.println(
                "bll: " + Long.toBinaryString(bll)
        );

        float f1=1;
        float f2 = 1F;// float 型后缀
        float f3 = 1f;//float 型后缀
        double d1 = 1d; // double 型后缀
        double d2 = 1D; // double 型后缀
    }
}
