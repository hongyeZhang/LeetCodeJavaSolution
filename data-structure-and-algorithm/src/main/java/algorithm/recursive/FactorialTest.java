package algorithm.recursive;

/**
 * @program: data-structure-and-algorithm
 * @description: 求阶乘 n!  5! = 120
 * @author: ZHQ
 * @create: 2019-07-07 19:56
 **/
public class FactorialTest {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial2(5));

    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return n * factorial(n - 1);
    }

    public static int factorial2(int n) {
        int ret = 1;
        for (int i = 1; i <= n; ++i) {
            ret = ret * i;
        }
        return ret;
    }
}
