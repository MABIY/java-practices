package chapter3.practice;

import static util.Print.print;

/**
 * @author lh
 */
class Tube {
    float level;
}

/**
 * @author lh
 */
public class Assign {
    public static void main(String[] args) {
        Tube t1 = new Tube();
        Tube t2 = new Tube();

        t1.level = 0.9f;
        t2.level = 0.47f;
        print("1: t1.level:" + t1.level + ", t2.level: " + t2.level);
        t1 = t2;
        print("2: t1.level:" + t1.level + ", t2.level: " + t2.level);
        t1.level = 0.27f;
        print("3: t1.level:" + t1.level + ", t2.level: " + t2.level);
    }
}
