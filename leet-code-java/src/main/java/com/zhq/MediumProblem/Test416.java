package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/27 16:10
 */
public class Test416 {

    /**
     * dp[i][j] 代表前面 i 个数组，是否能够组成和为 j 的子集
     *
     * 0 - 1 背包问题的改编
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 和为奇数时，不可能划分成两个和相等的集合
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= sum; ++j) {
                if (nums[i-1] > j) {
                    // 背包容量不足，不能装入第 i 个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 5, 10, 6};
        System.out.println(canPartition(nums));

    }

}
