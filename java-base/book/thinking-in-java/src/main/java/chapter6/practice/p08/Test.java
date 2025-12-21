package chapter6.practice.p08;
/**
 * @author lh
 */
public class Test {
    public static void main(String[] args) {

        var ac = ConnectionManager_pc6_08.getConnection();
        System.out.println(ac);

        var ac1 = ConnectionManager_pc6_08.getConnection();
        System.out.println(ac1);

        var ac2 = ConnectionManager_pc6_08.getConnection();
        System.out.println(ac2);

        System.out.println(ConnectionManager_pc6_08.getConnection());
    }
}
