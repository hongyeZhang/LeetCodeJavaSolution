package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class Interview21 {

    /** 对撞指针
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        if (null == nums || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int len = nums.length;
        int oddIndex = 0, evenIndex = len - 1;
        while (oddIndex < evenIndex) {
            while (oddIndex < evenIndex && isOddNum(nums[oddIndex])) {
                oddIndex++;
            }
            while (oddIndex < evenIndex && !isOddNum(nums[evenIndex])) {
                evenIndex--;
            }
            swap(nums, oddIndex, evenIndex);
        }
        return nums;
    }

    public static boolean isOddNum(int a) {
        return (a & 1) == 1;
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 7, 8, 9};
        int[] exchange = exchange(nums);
        for (int i : exchange) {
            System.out.print(i + " ");
        }
    }


}
