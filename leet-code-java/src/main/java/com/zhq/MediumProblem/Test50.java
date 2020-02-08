package com.zhq.MediumProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/7
 */
public class Test50 {
    public static void main(String[] args) {
        double x = 2;
        int n = -2;
        System.out.println(myPowMethod1(x, n));
        System.out.println(myPow(x, n));

    }

    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    /** 快速幂计算，需要区分奇、偶
     * @param x
     * @param n
     * @return
     */
    public static double fastPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            // 偶数
            return half * half;
        } else {
            return half * half * x;
        }
    }




    /** 暴力解法
     * @param x
     * @param n
     * @return
     */
    public static double myPowMethod1(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++) {
            ans = ans * x;
        }
        return ans;
    }
}
