package streams;

import java.util.stream.IntStream;

/**
 * @author lh
 */
public class Range {
    public static void main(String[] args) {
        //传统方法:
        int result =0;
        for (int i = 0; i <20; i++) {
            result +=i;
        }
        System.out.println(result);

        // for-in 循环:
        result = 0;

        for (int i : IntStream.range(10,20).toArray()) {
            result +=i;
        }
        System.out.println(result);
        // 使用流
        System.out.println(IntStream.range(10,20).sum());
    }
}
