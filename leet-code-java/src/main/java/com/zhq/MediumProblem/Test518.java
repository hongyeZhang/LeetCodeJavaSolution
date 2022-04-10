package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/27 20:07
 */
public class Test518 {

    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // base case : dp[i][0] = 1
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= amount; ++j) {
                if (coins[i - 1] <= j) {
                    // 注意此处的状态转移方程，因为硬币是可重复使用的，所以此处 dp[i][j-coins[i-1]] 而不是 dp[i-1][j-coins[i-1]]
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    @Test
    public void test() {
        int[] coins = new int[]{10};
        int amount = 10;
        System.out.println(change(amount, coins));
    }

}
