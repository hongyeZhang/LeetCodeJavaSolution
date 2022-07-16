package com.zhq.SimpleProblem;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : ZHQ
 * @date : 2020/4/24
 */
public class Test198 {

    /**
     *
     * 动态规划
     * dp[i] 代表截至当前 index = i 时抢劫能够获得的最大收益
     * 方程：dp[i] = MAX( dp[i-1], dp[i-2] + num )
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
        int[] nums = new int[] {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
        System.out.println(rob2(nums));
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(nums, 0, memo);
    }

    /**
     * dp[i] 是 从 i 开始抢劫所能够获得的最多收益
     * @param nums
     * @param start
     * @param memo
     * @return
     */
    public int dp(int[] nums, int start, int[] memo) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        int res = Math.max(dp(nums, start + 1, memo), nums[start] + dp(nums, start + 2, memo));
        memo[start] = res;
        return res;
    }


}
