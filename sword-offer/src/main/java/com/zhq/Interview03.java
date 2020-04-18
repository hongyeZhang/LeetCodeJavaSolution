package com.zhq;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/2/29
 */
public class Interview03 {

    /**
     * 借助辅助数组实现
     * @param nums
     * @return
     */
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

    public int findRepeatNumber2(int[] nums) {
        int length = nums.length;
        int repeatNum = -1;
        for (int i = 0; i < length; ++i) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    repeatNum = nums[i];
                    break;
                }
                swap(nums, i, nums[i]);
            }
        }
        return repeatNum;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {
        int[] input = new int[] {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber2(input));
    }




    public static void main(String[] args) {

        int[] input = new int[] {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(input));


    }
}
