package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/6
 */
public class Interview63 {

    public static int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }

        int len = prices.length;
        int minPrice = prices[0];
        int maxProfit = prices[1] - prices[0];
        if (len > 2) {
            for (int i = 2; i < len; ++i) {
                minPrice = Math.min(minPrice, prices[i - 1]);
                int currentMaxProfit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, currentMaxProfit);
            }
        }
        return Math.max(maxProfit, 0);
    }


    public static void main(String[] args) {
        int[] nums = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));


    }

}
