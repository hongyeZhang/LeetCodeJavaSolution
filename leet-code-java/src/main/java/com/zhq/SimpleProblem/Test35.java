package com.zhq.SimpleProblem;

/**
 * @program: LeetCodeTest
 * @description: 搜索插入位置
 * @author: ZHQ
 * @create: 2019-06-01 22:17
 **/
public class Test35 {

    public static void main(String[] args) {

        Test35 test35 = new Test35();
        int[] nums = {1,2,4,6,7};
//        System.out.println(test35.searchInsert(nums, 5));
        System.out.println(test35.searchInsert(nums, 3));
//        System.out.println(test35.searchInsert(nums, 7));
//        System.out.println(test35.searchInsert(nums, 0));

    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            if (target <= nums[0]) {
                return 0;
            }
            return 1;
        }

        // 初步打算进行两次二分查找
        int left = 0;
        int right = len - 1;

        // 先查找，如果不存在，则返回
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (target == nums[pivot]) {
                return pivot;
            }
            if (target > nums[pivot]) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        // 未查到
        int index = -1;
        int left1 = 0;
        int right1 = len - 1;
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[len - 1]) {
            return len;
        }
        while (left1 <= right1) {
            int pivot1 = (left1 + right1) / 2;
            int pivot2 = pivot1 + 1;
            if (target > nums[pivot1] && target < nums[pivot2]) {
                return pivot2;
            } else if (target < nums[pivot1]) {
                right1 = pivot1;
            } else {
                left1 = pivot2;
            }
        }

        return 0;
    }
}
