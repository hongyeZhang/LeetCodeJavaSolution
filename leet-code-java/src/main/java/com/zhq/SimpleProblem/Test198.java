package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/24
 */
public class Test198 {

    /**
     *
     * 动态规划
     *
     * 方程：dp[n] = MAX( dp[n-1], dp[n-2] + num )
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= len; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[len];
    }




    @Test
    public void test() {
//        int[] nums = new int[] {1, 2, 3, 1};
        int[] nums = new int[] {2, 7, 9, 3, 1};
        System.out.println(rob(nums));


    }




}
