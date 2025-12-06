package chapter2.content;

/**
 * @author lh
 */
public class Test {
    private static char a;

    public static void main(String[] args){
        String s = "ABC\u0000DEF";
        System.out.println("长度："+s.length());
        for(int i = 0; i < s.length(); i++) {
            System.out.println((int)s.charAt(i));
        }
    }

}
