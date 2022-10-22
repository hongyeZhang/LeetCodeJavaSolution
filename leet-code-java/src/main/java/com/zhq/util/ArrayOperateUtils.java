package com.zhq.util;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/16 16:25
 */
public final class ArrayOperateUtils {

    private ArrayOperateUtils() {
    }

    public static void swapIntArray(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



}
