package collections;

import java.util.ArrayList;

/**
 * @author lh
 * NewFeature 从 jdk11 开始
 */
public class GenericTypeInterface {
    void old() {
        ArrayList<Apple> apples = new ArrayList<>();
    }
    void modern() {
        var apples = new ArrayList<Apple>();
    }

    void pitFall() {
        var apples = new ArrayList<>();
        apples.add(new Apple());
        apples.get(0); // 作为普通的Object类型返回
    }
}
