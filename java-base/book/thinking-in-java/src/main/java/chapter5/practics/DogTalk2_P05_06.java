package chapter5.practics;
/**
 * Create a class with a default constructor (ont that takes no arguments) that
 * prints a messages. Create an object of this class.
 * @author lh
 */
class Dog1{
    void bark(){System.out.println("quiet");}
    void bark(char c){System.out.println("cawcaw");}
    void bark(byte b){System.out.println("barkbark");}
    void bark(short b){System.out.println("slurpslurps");}
    void bark(int i){System.out.println("iyow");}
    void bark(long l){System.out.println("lalala");}
    void bark(float f){System.out.println("fififoofum");}
    void bark(double d){System.out.println("dodo");}
    void bark(char c ,int i) {
        System.out.println("caw-iyow");
        };
    void bark(int i,char c){
        System.out.println("iyow-caw");
    }

}
public class DogTalk2_P05_06 {
    public static void main(String[] args){
        Dog1 d = new Dog1();
        char c = 'c';
        byte b=  0;
        short s = 0;
        d.bark();
        d.bark(c);
        d.bark(b);
        d.bark(s);
        d.bark(1);
        d.bark(1L);
        d.bark(1.0f);
        d.bark(1.0);
        d.bark(c,1);
        d.bark(1,c);
    }
}
