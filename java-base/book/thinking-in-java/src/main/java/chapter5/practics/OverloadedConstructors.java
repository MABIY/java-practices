package chapter5.practics;
/**
 * Create a class with two(overloaded) constructor.  Using 'this', call
 * the second constructor from inside the first one.
 * @author lh
 */
class Doc1{
     Doc1(int i) {
        this("MD");
        int yearsTraining = i;
        System.out.println("New doc with " + i + " years of training");
    }
    Doc1(String s){
         String degree = s;
         System.out.println("New doc with " + s + " degree");
    }
    void intubate(){
         System.out.println("prepare patient");
         laryngoscopy();
    }

    void laryngoscopy(){
         System.out.println("use laryngoscopy");
    }
}
public class OverloadedConstructors {
    public static void main(String[] args){
        new Doc1(8).intubate();
    }
}
