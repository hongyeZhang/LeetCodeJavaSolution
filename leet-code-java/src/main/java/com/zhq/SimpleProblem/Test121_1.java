package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/17 09:59
 */
public class Test121_1 {


    /**
     * 写动态规划的状态转移方程
     * 从买入的时候计入一次交易， k-1
     * 第 i 天，最多可以交易 k 次，0为不持有，1为持有
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * 此题 k =1
     * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     * dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
     *             = max(dp[i-1][1][1], -prices[i])
     * 与k无关
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], -prices[i])
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; ++i) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    @Test
    public void test() {
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }



}
