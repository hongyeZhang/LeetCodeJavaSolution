package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : ZHQ
 * @date : 2020/4/18
 */
public class Test279_2 {

    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int maxNum = (int) Math.ceil(Math.sqrt(n)) + 1;
        int[] squareNums = new int[maxNum];
        for (int i = 1; i < maxNum; ++i) {
            squareNums[i] = i * i;
        }

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < maxNum; ++s) {
                if (i < squareNums[s]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - squareNums[s]] + 1);
            }
        }

        return dp[n];
    }

    @Test
    public void test() {

        System.out.println(numSquares(12));
        System.out.println(numSquares(13));

    }


}
