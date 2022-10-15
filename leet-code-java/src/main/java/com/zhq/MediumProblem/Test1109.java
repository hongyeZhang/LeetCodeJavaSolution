package com.zhq.MediumProblem;

import com.zhq.util.PrintUtils;
import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/9 23:47
 */
public class Test1109 {

    @Test
    public void test() {
        int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] ints = corpFlightBookings(bookings, 5);
        PrintUtils.printArray(ints);
    }


    /**
     * 典型的查分数组问题，转换一下坐标即可
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        if (bookings == null || bookings[0].length == 0 || n <= 0) {
            return null;
        }
        int[] nums = new int[n];
        DifferenceArray differenceArray = new DifferenceArray(nums);
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
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
