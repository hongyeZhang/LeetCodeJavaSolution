package com.zhq.SimpleProblem;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最长连续递增序列的长度
 * @author : ZHQ
 * @date : 2020/4/4
 */
public class Test674 {

    /**
     *  动态规划即可，一个极其简单的解题方式
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }


    @Test
    public void test() {
        int[] nums1 = new int[] {1, 3, 5, 4, 7};
        int[] nums2 = new int[] {2, 2, 2, 2, 2};

        System.out.println(findLengthOfLCIS(nums1));
        System.out.println(findLengthOfLCIS(nums2));

    }




}
