package Lambda;

/**
 * @author lykis
 */
public class TestLambda02 {
    public static void main(String[] args) {

        ILove love = (int a) -> {
            System.out.println("Love " + a);
        };
        love.love(100);

        // 简化1：减去参数类型说明
        love = (a) -> {
            System.out.println("Love " + a);
        };
        love.love(120);

        // 简化2：简化括号(多个参数则不能简化)
        love = a -> {
            System.out.println("Love " + a);
        };
        love.love(140);

        // 简化3：简化花括号(若大于一行，则不能简化花括号)
        love = a -> System.out.println("Love " + a);
        love.love(160);

        ATest testUser = (a, b) -> System.out.println("Testing " + a + " is " + b);
        testUser.test(20, "ab");

    }
}

/**
 * 1. 定义一个函数式接口
 */
interface ILove {
    void love(int a);
}

interface ATest {
    void test(int a, String b);
}

