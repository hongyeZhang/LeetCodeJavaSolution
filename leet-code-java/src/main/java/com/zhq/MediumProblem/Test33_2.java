package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/22 09:52
 */
public class Test33_2 {

    public int search(int[] nums, int target) {
        return doSearch(nums, 0, nums.length - 1, target);
    }

    /**
     * 注意：一个旋转数组从中间分成两部分，一定有一部分是有序的。
     * 本题目 与 81 题的区别是：数组 nums 中的数字互不相同
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public int doSearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[left] < nums[mid]) {
            // 左半边有序
            if (target > nums[left] && target < nums[mid]) {
                return doSearch(nums, left + 1, mid - 1, target);
            } else {
                return doSearch(nums, mid + 1, right - 1, target);
            }
        } else {
            // 右半边有序
            if (target > nums[mid] && target < nums[right]) {
                return doSearch(nums, mid + 1, right - 1, target);
            } else {
                return doSearch(nums, left + 1, mid - 1, target);
            }
        }
    }


    @Test
    public void test() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int search = search(nums, 1);
        System.out.println(search);
    }

}
