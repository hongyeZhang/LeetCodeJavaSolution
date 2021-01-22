package com.zhq.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 * 回溯算法1
 * @Author: ZHQ
 * @Date: 2020/12/15
 */
public class Test46 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return Collections.emptyList();
        }
        List<List<Integer>> retList = new ArrayList<>();
        backtrack(nums, 0, nums.length, retList);
        return retList;
    }

    public void backtrack(int[] nums, int index, int length, List<List<Integer>> retList) {
        if (index == length - 1) {
            List<Integer> tmpList = new ArrayList<>();
            for (int num : nums) {
                tmpList.add(num);
            }
            retList.add(tmpList);
            return;
        }

        for (int i = index; i < length; ++i) {
            swap(nums, index, i);
            backtrack(nums, index + 1, length, retList);
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
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> integers : permute) {
            for (Integer integer : integers) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

}
