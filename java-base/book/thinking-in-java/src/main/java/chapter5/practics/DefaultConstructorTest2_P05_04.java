package chapter5.practics;
/**
 * Add an overloaded constructor to the previous exercise that take a string argument
 * and prints it along with your messages.
 * @author lh
 */
class Kabayo2{
  Kabayo2(){
      System.out.println("isa lang kabayo");
  }
  Kabayo2(String s){
      System.out.println(s +" isa lang kabayo");
  }
}
public class DefaultConstructorTest2_P05_04 {
    public static void main(String[] args){
        Kabayo2 k = new Kabayo2();
        Kabayo2 k2 = new Kabayo2("tumutugtog ng gitara");
    }
}
