package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test121 {

    /**
     * 更新到目前时间的价格的最小值和利润的最大值
     *
     *
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


    @Test
    public void test() {
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));




    }


}
