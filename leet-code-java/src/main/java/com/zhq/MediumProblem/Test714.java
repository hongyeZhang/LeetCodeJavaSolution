package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/18 10:55
 */
public class Test714 {

    /**
     *
     * 写动态规划的状态转移方程
     * 从买入的时候计入一次交易， k-1
     * 第 i 天，最多可以交易 k 次，0为不持有，1为持有
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i] - fee)
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * 此题 k = infinity，消掉 k 可得
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i] - fee)
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    @Test
    public void test() {
        int[] prices = new int[]{1, 3, 7, 5, 10, 3};
        System.out.println(maxProfit(prices, 3));
    }

}
