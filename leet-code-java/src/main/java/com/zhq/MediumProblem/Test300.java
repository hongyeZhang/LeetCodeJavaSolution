package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/4
 */
public class Test300 {

    /** 最长递增子序列的长度，不要求连续
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }

        int len = nums.length;
        int[] dp = new int[len];
        // 初始化数组
        for (int i = 0; i < len; ++i) {
            dp[i] = 1;
        }

        for (int i = 1; i < len; ++i) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int ret = dp[0];
        for (int i : dp) {
            ret = Math.max(ret, i);
        }

        return ret;
    }

    @Test
    public void test() {
        int[] nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
