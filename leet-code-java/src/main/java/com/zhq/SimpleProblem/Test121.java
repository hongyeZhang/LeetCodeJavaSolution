package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test121 {

    /**
     * 更新到目前时间的价格的最小值和利润的最大值
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }

        int minPrice = Math.min(prices[0], prices[1]);
        int maxProfit = prices[1] - prices[0];
        for (int i = 2; i < prices.length; ++i) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return Math.max(0, maxProfit);
    }

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
    public int maxProfitDynamicPlanning(int[] prices) {
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
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

    }


}
