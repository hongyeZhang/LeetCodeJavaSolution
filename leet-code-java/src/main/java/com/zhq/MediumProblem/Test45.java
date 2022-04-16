package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/4/12 10:38
 */
public class Test45 {


    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, n);
        return dp(nums, 0, memo);
    }

    /**
     * dp[p] 从 index=p 的位置跳到最后所需要的最少的步数
     * @param nums
     * @param p
     * @return
     */
    public int dp(int[] nums, int p, int[] memo) {
        // base case
        if (p >= nums.length - 1) {
            return 0;
        }
        if (memo[p] != nums.length) {
            return memo[p];
        }
        int steps = nums[p];
        for (int i = 1; i <= steps; ++i) {
            int subProblem = dp(nums, p + i, memo);
            memo[p] = Math.min(memo[p], subProblem + 1);
        }
        return memo[p];
    }

    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }


}
