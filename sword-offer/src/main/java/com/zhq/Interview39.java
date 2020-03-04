package com.zhq;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author : ZHQ
 * @date : 2020/3/3
 */
public class Interview39 {

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 2];
    }

    /** 寻找第k大的数字  此时 k = length /2  时间复杂度 O(N)
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        if (null == nums ) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int middle = len >> 1;

        int index = partition(nums, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(nums, start, end);
            } else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }

        return nums[index];
    }

    public static int partition(int[] nums, int left, int right) {
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



    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2};
//        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));



    }
}
