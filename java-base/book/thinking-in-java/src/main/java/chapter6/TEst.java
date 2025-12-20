package chapter6;

import java.util.HashMap;

/**
 * @author lh
 */
public class TEst {
    public static void main(String[] args){
        HashMap<Object, Object> objectObjectHashMap =
                new HashMap<>() {
                    {
                        put("test", "test");
                    }
                };
    }
}
