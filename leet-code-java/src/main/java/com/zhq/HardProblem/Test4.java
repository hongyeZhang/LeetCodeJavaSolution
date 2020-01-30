package com.zhq.HardProblem;

import java.util.Arrays;

/**
 * @program: LeetCodeTest
 * @description: 两个排序数组的中位数
 * @author: ZHQ
 * @create: 2018-10-21 21:59
 **/
public class Test4 {

    /**
     * @Description: 时间复杂度为 O(log(m+n))
     * @Param: [nums1, nums2]
     * @return: double
     * @Author: ZHQ
     * @Date: 2018/10/21
     **/
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        // 数组合并
        int[] mergeArray = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, mergeArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergeArray, nums1.length, nums2.length);
        //数组排序
        Arrays.sort(mergeArray);
        int length = mergeArray.length;
        if (length % 2 == 0) {
            // 偶数
            median = ((double) (mergeArray[length / 2] + mergeArray[length / 2 - 1])) / 2;
        } else {
            median = mergeArray[(length - 1) / 2];
        }

        return median;
    }


    public static void main(String[] args) {

        int[] input1 = {1, 2};
        int[] input2 = {3, 4};

        System.out.println(findMedianSortedArrays(input1, input2));

    }
}
