package com.zhq.dynamicPlanning;

import org.junit.Test;

/**
 * 斐波那契数
 * @Author: ZHQ
 * @Date: 2020/12/15
 */
public class Test509 {

    public int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1 || N == 2) {
            return 1;
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= N; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    /**
     * 空间复杂度 O(1)
     * @param N
     * @return
     */
    public int fib2(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1 || N == 2) {
            return 1;
        }

        int pre = 1;
        int cur = 1;
        int result = 0;
        for (int i = 3; i <= N; ++i) {
            result = pre + cur;
            pre = cur;
            cur = result;
        }
        return result;
    }


    @Test
    public void test1() {
        System.out.println(fib(10));
        System.out.println(fib2(10));
    }








}
