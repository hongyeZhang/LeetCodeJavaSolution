package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class TempTest {
    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[2] = Integer.MIN_VALUE;
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
