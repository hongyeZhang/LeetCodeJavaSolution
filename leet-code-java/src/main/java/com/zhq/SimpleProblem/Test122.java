package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test122 {

    public int maxProfit(int[] prices) {
        return maxProfitCore(prices, 0);
    }

    /**
     * 暴力求解 （超时）
     * @param prices
     * @param startIndex
     * @return
     */
    public int maxProfitCore(int[] prices, int startIndex) {
        if (startIndex >= prices.length) {
            return 0;
        }
        int max = 0;
        for (int i = startIndex; i < prices.length; ++i) {
            int maxProfit = 0;
            for (int j = i + 1; j < prices.length; ++j) {
                int profit = 0;
                if (prices[j] - prices[i] > 0) {
                    profit = prices[j] - prices[i] + maxProfitCore(prices, j + 1);
                    maxProfit = Math.max(profit, maxProfit);
                }
            }
            max = Math.max(max, maxProfit);
        }
        return max;
    }

    @Test
    public void test1() {
//        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
//        int[] prices = new int[] {1, 2, 3, 4, 5};
        int[] prices = new int[] {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }

}
