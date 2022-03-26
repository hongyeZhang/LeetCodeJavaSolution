package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/20 10:13
 */
public class Test53_2 {

    /**
     * dp[i]定义：以 nums[i] 为结尾的最大子数组的和
     * 对于 dp[i+1] 要么接到上一个子数组的和上，要么重新开启一个子数组 dp[i+1] = Math.max(nums[i+1], dp[i]+nums[i])
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp_i = nums[0];
        int n = nums.length;
        int res = dp_i;
        int dp_i1 = 0;
        for (int i = 1; i < n; ++i) {
            dp_i1 = Math.max(nums[i], nums[i] + dp_i);
            res = Math.max(res, dp_i1);
            dp_i = dp_i1;
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray2(nums));
    }

}
