package algorithm.recursive;

/**
 * @program: data-structure-and-algorithm
 * @description: 斐波那契数列求值f(n)=f(n-1)+f(n-2)
 *  1,1,2,3,5,8,13,21
 * @author: ZHQ
 * @create: 2019-07-07 18:33
 **/
public class FibonacciTest {

    public static void main(String[] args) {
        System.out.println(fibonacciRecursion(7));
        System.out.println(fibonacci(7));
    }


    public static int fibonacciRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
        }
    }

    /**
    * @Description: 非递归解法
    **/
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int result = 0;
        int preResult = 1;
        int currentResult = 1;
        for (int i = 3; i <= n; ++i) {
            result = currentResult + preResult;
            preResult = currentResult;
            currentResult = result;
        }
        return result;
    }

}
