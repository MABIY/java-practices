package chapter5.practics;
/**
 * Create a class with a default constructor (ont that takes no arguments) that
 * prints a messages. Create an object of this class.
 * @author lh
 */
class Dog{
    void bark(){System.out.println("quiet");}
    void bark(char c){System.out.println("cawcaw");}
    void bark(byte b){System.out.println("barkbark");}
    void bark(short b){System.out.println("slurpslurps");}
    void bark(int i){System.out.println("iyow");}
    void bark(long l){System.out.println("lalala");}
    void bark(float f){System.out.println("fififoofum");}
    void bark(double d){System.out.println("dodo");}
}
public class DogTalk_P05_05 {
    public static void main(String[] args){
        Dog d = new Dog();
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

    }
}
