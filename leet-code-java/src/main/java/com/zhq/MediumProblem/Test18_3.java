package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/19 10:37
 */
public class Test18_3 {

    /**
     * 如果是 nSum 的问题，则通过递归的方式处理
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> retList = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> threeSumList = threeSum(nums, i + 1, target - nums[i]);
            if (!threeSumList.isEmpty()) {
                for (List<Integer> list : threeSumList) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.addAll(list);
                    retList.add(tmpList);
                }
            }
        }
        return retList;
    }


    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> retList = new ArrayList<>();
        for (int i = start; i < nums.length - 2; ++i) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> twoSumRetList = twoSum(nums, i + 1, target - nums[i]);
            if (!twoSumRetList.isEmpty()) {
                for (List<Integer> list : twoSumRetList) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.addAll(list);
                    retList.add(tmpList);
                }
            }
        }
        return retList;
    }

    /**
     * 计算从 start 开始计算的两数之和
     * @param sortedNums
     * @param start
     * @param target
     * @return
     */
    public List<List<Integer>> twoSum(int[] sortedNums, int start, int target) {
        List<List<Integer>> retList = new ArrayList<>();
        int left = start;
        int right = sortedNums.length - 1;
        while (left < right) {
            int leftVal = sortedNums[left];
            int rightVal = sortedNums[right];
            int sum = leftVal + rightVal;
            if (sum == target) {
                retList.add(Arrays.asList(leftVal, rightVal));
                while (left < right && sortedNums[left] == leftVal) {
                    left++;
                }
                while (left < right && sortedNums[right] == rightVal) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return retList;
    }


    @Test
    public void test() {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSum(nums, 0);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }


    }





}
