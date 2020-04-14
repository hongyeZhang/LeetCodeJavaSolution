package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test122_2 {

    /**
     * 峰谷法，找个每个高峰和每个低估，然后卖出去
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int valley, peak;
        int i = 0;
        int len = prices.length;
        while (i < len - 1) {
            while (i < len - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < len - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }

    @Test
    public void test() {
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

    }





}
