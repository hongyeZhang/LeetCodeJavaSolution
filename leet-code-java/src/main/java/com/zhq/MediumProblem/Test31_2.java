package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/15
 */
public class Test31_2 {

    public void nextPermutation(int[] nums) {
        if (null == nums || nums.length < 2) {
            return;
        }
        int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = len - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        inverseArrayFromIndexToEnd(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void inverseArrayFromIndexToEnd(int[] nums, int Index) {
        int left = Index;
        int right = nums.length - 1;
        while (left < right) {
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            left++;
            right--;
        }
    }


    @Test
    public void test() {
//        int[] nums = new int[] {1, 2, 3};
        int[] nums = new int[] {3, 2, 1};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }


    }





}
