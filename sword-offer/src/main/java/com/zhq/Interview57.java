package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/5
 */
public class Interview57 {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null | nums.length < 2) {
            return new int[0];
        }
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            if (nums[leftIndex] + nums[rightIndex] == target) {
                return new int[] {nums[leftIndex], nums[rightIndex]};
            } else if (nums[leftIndex] + nums[rightIndex] > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {2, 7, 11, 15};
        int[] nums2 = new int[] {10, 26, 30, 31, 47, 60};

        int[] ints = twoSum(nums2, 40);
        for (int anInt : ints) {
            System.out.print(anInt + "\t");
        }



    }
}
