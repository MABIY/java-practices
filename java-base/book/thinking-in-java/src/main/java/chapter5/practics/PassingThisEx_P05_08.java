package chapter5.practics;
/**
 * Create a class with two methods, Within the first method, call the
 * second method twice:the first time without using this, and the second time
 * using this - just to see it working: you should not use this form in
 * practice.
 * @author lh
 */
class Doc{
    void intubate(){
        System.out.println("prepare patient");
        laryngoscopy();
        this.laryngoscopy();
    }
    void laryngoscopy(){
        System.out.println("use laryngoscopy");
    }
}
/**
 * @author lh
 */
public class PassingThisEx_P05_08 {
    public static void main(String[] args){
        new Doc().intubate();
    }
}
