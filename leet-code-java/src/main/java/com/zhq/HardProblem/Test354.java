package com.zhq.HardProblem;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/27 11:15
 */
public class Test354 {


    /**
     * 先对宽度 w 进行升序排序，如果遇到 w 相同的情况，则按照高度 h 降序排序；之后把所有的 h 作为一个数组，在这个数组上计算 LIS 的长度就是答案。
     * 思路比较明确，但实际上  leetcode 上提交会超时
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int n = envelopes.length;
        int[] height = new int[n];
        for (int i = 0; i < envelopes.length; ++i) {
            height[i] = envelopes[i][1];
        }
        return maxLengthOfLIS(height);
    }

    public int maxLengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = dp[0];
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}};
        System.out.println(maxEnvelopes(matrix));

    }
}
