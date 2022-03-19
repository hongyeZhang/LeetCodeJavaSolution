package com.zhq.HardProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/17 23:47
 */
public class Test188 {

    /**
     * 直接套公式即可
     * @param kk
     * @param prices
     * @return
     */
    public int maxProfit(int kk, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int maxK = kk;
        int[][][] dp = new int[n][maxK + 1][2];
        for (int i = 0; i < n; ++i) {
            for (int k = 1; k <= maxK; ++k) {
                if (i == 0) {
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][maxK][0];
    }

    @Test
    public void test() {

    }
}
