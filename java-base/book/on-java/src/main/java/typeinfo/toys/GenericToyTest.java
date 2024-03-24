package typeinfo.toys;

import java.lang.reflect.InvocationTargetException;

/**
 * @author lh
 */
public class GenericToyTest {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<FancyToy> ftc = FancyToy.class;
        // 生成确切的类型
        FancyToy fancyToy = ftc.getConstructor().newInstance();
        Class<? super FancyToy> up = ftc.getSuperclass();
        // 下面的代码无法通过编译
//        Class<Toy> up2 = ftc.getSuperclass();
    }
}
