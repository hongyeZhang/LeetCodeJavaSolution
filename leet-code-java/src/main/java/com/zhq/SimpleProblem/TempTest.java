package com.zhq.SimpleProblem;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-05-19 22:18
 **/
public class TempTest {


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
        int[] nums = new int[]{1, 3, 5, 4, 7};
        System.out.println(findLengthOfLCIS(nums));
    }


}
