package com.zhq.MediumProblem;

import com.zhq.util.PrintUtils;
import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/9 10:07
 */
public class Test370 {

    @Test
    public void test() {
        int[][] updates = new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int[] modifiedArray = getModifiedArray(5, updates);
        PrintUtils.printArray(modifiedArray);
    }

    /**
     * 差分数组题目，leetcode-plus 题目
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        DifferenceArray differenceArray = new DifferenceArray(nums);
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            differenceArray.increment(i, j, val);
        }
        return differenceArray.constructOriginArray();
    }


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





}


