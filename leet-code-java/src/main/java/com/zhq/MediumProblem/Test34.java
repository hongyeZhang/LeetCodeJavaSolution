package com.zhq.MediumProblem;

/**
 * @program: LeetCodeTest
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * @author: ZHQ
 * @create: 2019-06-01 21:35
 **/
public class Test34 {

    public static void main(String[] args) {

//        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums = {5, 7, 7, 8, 8, 10};

        Test34 test34 = new Test34();
        int[] ret = test34.searchRange(nums, 8);
        for (int i : ret) {
            System.out.print(i + "\t");
        }

    }


    /**
    * @Description: ZHQ
    * @Param:
    * @return:
    * @Author: ZHQ
    * @Date: 2019/6/1
    **/
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        if (len == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }
        if (target < nums[0] || target > nums[len - 1]) {
            return new int[]{-1,-1};
        }

        int start = -1;
        int end = -1;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (target == nums[pivot]) {
                int startIndex = pivot;
                int endIndex = pivot;
                while (startIndex >= 0 && nums[startIndex] == target) {
                    startIndex--;
                }
                start = startIndex + 1;

                while (endIndex <= len - 1 && nums[endIndex] == target) {
                    endIndex++;
                }
                end = endIndex - 1;
                break;
            } else if (target > nums[pivot]) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return new int[]{start, end};

    }
}
