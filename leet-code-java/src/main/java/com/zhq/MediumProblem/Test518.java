package com.zhq.MediumProblem;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ZHQ
 * @date 2022/7/23
 */
public class Test518 {

    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
        int n = coins.length;
        // dp[i][j] 代表使用第 i 枚硬币，组成金额为 j 的方法总数
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= amount; ++j) {
                if (coins[i - 1] > j) {
                    // 硬币金额大于总金额
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

    @Test
    public void test() {
        int[] coins = new int[]{1, 2, 5};
        int amount = 5;
        Assert.assertEquals(4, change(amount, coins));

    }
}
