package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/2/29
 */
public class Interview03 {

    public static int findRepeatNumber(int[] nums) {
        int length = nums.length;
        int[] flagArray = new int[length];
        for (int i = 0; i < length; ++i) {
            if (flagArray[nums[i]] == 0) {
                flagArray[nums[i]] = 1;
            } else if (flagArray[nums[i]] == 1){
                return nums[i];
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {

        int[] input = new int[] {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(input));

    }
}
