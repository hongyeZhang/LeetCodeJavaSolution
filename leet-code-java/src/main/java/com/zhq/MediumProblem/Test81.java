package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/21 10:35
 */
public class Test81 {

    /**
     * 与 31 题不同的是，本题的排序数组中存在重复的数字
     * 存在重复的数字，就无法直接判断出某一个区间是升序还是降序，因此做法是将区间的边界简单的向内移动一步
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        // TODO: 2022/2/22
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if(nums[left] == nums[mid]){
                left++;
            } else if(nums[right] == nums[mid]) {
                right--;
            } else if (nums[left] < nums[mid]) {
                // 左边的区间有序
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边的区间有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 5};
        boolean search = search(nums, 1);
        System.out.println(search);


    }

}
