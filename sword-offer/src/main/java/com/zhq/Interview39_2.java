package com.zhq;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/19
 */
public class Interview39_2 {

    public int majorityElement(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int middle = nums.length >> 1;
        int index = partition(nums, start, end);
        while (index != middle) {
            while (index > middle) {
                end = index - 1;
                index = partition(nums, start, end);
            }
            while (index < middle) {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }

        return nums[middle];
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    @Test
    public void test() {
//        int[] nums = new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2};

        int[] nums = new int[] {4, 5, 4};
        System.out.println(majorityElement(nums));
    }








}
