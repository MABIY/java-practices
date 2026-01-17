package chapter5;
/**
 * Demonstration of a simple constructor
 * @author lh
 */
class Rock{
    Rock(){ // This is the constructor
       System.out.println("Rock");
    }
    public void Rock(){
        System.out.println("method");
    }
}
public class SimpleConstructor {
    public static void main(String[] args){
        for(int i = 0; i <10 ; i++) {
            new Rock().Rock();
        }
    }
}
