package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/4/16 16:38
 */
public class Test213 {

    /**
     * 首尾连接的房子不能同时抢，那么要么第一家不抢，要么最后一家不抢，就分为两种情况，分别求出最值之后，再去最大值即可
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] nums1 = new int[n - 1];
        int[] nums2 = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            nums1[i] = nums[i];
        }
        for (int i = 1; i < n; ++i) {
            nums2[i - 1] = nums[i];
        }
        return Math.max(subRob(nums1), subRob(nums2));
    }


    public int subRob(int[] nums) {
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
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }

}
