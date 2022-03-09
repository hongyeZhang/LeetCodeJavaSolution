package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/21 09:13
 */
public class Test34_2 {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        int startIndex = -1, endIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                startIndex = mid;
                endIndex = mid;
                while (startIndex >= 0 && nums[startIndex] == target) {
                    startIndex--;
                }
                startIndex++;
                while (endIndex < len && nums[endIndex] == target) {
                    endIndex++;
                }
                endIndex--;
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{startIndex, endIndex};
    }


    @Test
    public void test() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] ints = searchRange(nums, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
