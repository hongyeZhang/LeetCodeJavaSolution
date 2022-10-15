package com.zhq.util;

/**
 * @description: 查分数组工具类
 * @author: jinpeng
 * @date: 2022/10/8 13:03
 */
public class DifferenceArray {

    private int[] diff;

    /**
     * 根据输入的数组构建差分数组
     * @param nums
     */
    public DifferenceArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public void printDifferenceArray() {
        PrintUtils.printArray(diff);
    }


    /**
     * 给 [i,j] 区间内的数组增加 val（可以为负数）
     * @param i
     * @param j
     * @param val
     */
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    /**
     * 由差分数组构造出原来的数组
     * @return
     */
    public int[] constructOriginArray() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; ++i) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
