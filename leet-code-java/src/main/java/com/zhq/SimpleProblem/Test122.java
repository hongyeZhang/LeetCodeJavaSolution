package com.zhq.SimpleProblem;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test122 {

    Map<Integer, Integer> memo = new HashMap<>();

    public int maxProfit(int[] prices) {
        return maxProfitCore(prices, 0, memo);
    }

    /**
     * 暴力求解 （超时）
     * @param prices
     * @param startIndex
     * @return
     */
    public int maxProfitCore(int[] prices, int startIndex, Map<Integer, Integer> memo) {
        if (startIndex >= prices.length) {
            return 0;
        }
        if (memo.containsKey(startIndex)) {
            return memo.get(startIndex);
        }
        int max = 0;
        for (int i = startIndex; i < prices.length; ++i) {
            int maxProfit = 0;
            for (int j = i + 1; j < prices.length; ++j) {
                int profit = 0;
                if (prices[j] - prices[i] > 0) {
                    profit = prices[j] - prices[i] + maxProfitCore(prices, j + 1, memo);
                    maxProfit = Math.max(profit, maxProfit);
                }
            }
            max = Math.max(max, maxProfit);
        }
        memo.put(startIndex, max);
        return max;
    }

    @Test
    public void test() {
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

}
