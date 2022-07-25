package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @author ZHQ
 * @date 2022/7/23
 */
public class Test416 {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        // dp[i][j] 代表有有i个石头时，能否填满容量为 j 的背包
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= sum; ++j) {
                if (nums[i - 1] > j) {
                    // 背包容量不足
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 容量充足时，可以选择装入或者不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];

    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }



}
