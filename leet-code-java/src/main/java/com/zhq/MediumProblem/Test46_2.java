package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ZHQ
 * @date 2022/2/28
 */
public class Test46_2 {


    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> retList = new ArrayList<>();
        backTrack(retList, nums, 0);
        return retList;
    }

    public void backTrack(List<List<Integer>> retList, int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> tmpList = new ArrayList<>();
            for (int num : nums) {
                tmpList.add(num);
            }
            retList.add(tmpList);
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            swap(nums, index, i);
            backTrack(retList, nums, index + 1);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> retList = permute(nums);
        for (List<Integer> integers : retList) {
            System.out.println(integers);
        }
    }
}
