package innerclasses.controller;

/**
 * @author lh
 */
interface Counter{
    int next();
}
public class LocalInnerClass {
    private int count = 0;
    Counter getCounter(final String name) {
        //一个局部内部类
        class LocalCounter implements Counter{
            public LocalCounter() {
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.print(name);
                return count++;
            }
        }

        return new LocalCounter();
    }

    // 使用匿名内部类实现同样的方法
    Counter getCounter2(String name){
        return new Counter() {
            // 只有一个实例初始化部分
            {
                System.out.println("Counter()");
            }
            @Override
            public int next() {
                System.out.print(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter c1  = lic.getCounter("Local inner"),
                c2 = lic.getCounter2("Anonymous inner");
        for (int i = 0; i <5; i++) {
            System.out.println(c1.next());
        }

        for (int i = 0; i < 5; i++){
            System.out.println(c2.next());
        }
    }
}
