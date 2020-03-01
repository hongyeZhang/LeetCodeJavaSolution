package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/2/29
 */
public class Interview10 {

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            int[] ret = new int[n + 1];
            ret[1] = 1;
            for (int i = 2; i <= n; ++i) {
                ret[i] = ret[i - 1] + ret[i - 2];
            }
            return ret[n];
        }
    }

    public static void main(String[] args) {

        System.out.println(fib(5));

    }


}
