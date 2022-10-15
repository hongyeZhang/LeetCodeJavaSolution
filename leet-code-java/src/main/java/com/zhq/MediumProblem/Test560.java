package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/4 10:40
 */
public class Test560 {


    @Test
    public void test() {
        int[] nums = new int[]{1, -1, 0};
        int k = 0;

        int res = subarraySum(nums, k);
        System.out.println(res);
    }

    /**
     * 两次循环前缀和数组，空间复杂度 O(N)，时间复杂度O(N^2)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 计算数组的前缀累积和
        int n = nums.length;
        int[] preSum = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                preSum[0] = nums[0];
                continue;
            }
            preSum[i] = preSum[i - 1] + nums[i];
        }

        // 穷举所有的子数组
        int res = 0;
        for (int i = 0; i < preSum.length; ++i) {
            if (preSum[i] == k) {
                res++;
            }
            for (int j = 0; j < i; ++j) {
                if (preSum[i] - preSum[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
