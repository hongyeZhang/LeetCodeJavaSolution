package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/27 16:45
 */
public class Test322 {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    @Test
    public void test() {
        int[] nums = new int[]{1};
        int amount = 1;
        System.out.println(coinChange(nums, amount));

    }
}
