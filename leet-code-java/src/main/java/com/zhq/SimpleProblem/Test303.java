package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/2 16:38
 */
public class Test303 {

    @Test
    public void test() {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        int ret = numArray.sumRange(2, 5);
        System.out.println(ret);
    }

}

class NumArray {

    private int[] prefixSum;

    public NumArray(int[] nums) {
        if (nums != null) {
            int n = nums.length;
            prefixSum = new int[n];
            for (int i = 0; i < n; ++i) {
                if (i == 0) {
                    prefixSum[0] = nums[0];
                } else {
                    prefixSum[i] = nums[i] + prefixSum[i - 1];
                }
            }
        }
    }

    /**
     * 通过前缀数组法，空间换时间，时间复杂度 O(1)
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        if (right < left) {
            return 0;
        }
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];
    }
}
