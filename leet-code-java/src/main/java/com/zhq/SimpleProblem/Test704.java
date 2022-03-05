package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/20 10:30
 */
public class Test704 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int search = search(nums, target);
        System.out.println(search);
    }

}
