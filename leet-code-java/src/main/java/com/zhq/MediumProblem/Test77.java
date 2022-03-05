package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/27 13:09
 */
public class Test77 {


    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return Collections.emptyList();
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = i + 1;
        }
        List<List<Integer>> retList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        backTrack(retList, nums, stack, 0, k);
        return retList;
    }


    public void backTrack(List<List<Integer>> retList, int[] nums, Stack<Integer> path, int index, int k) {
        if (path.size() == k) {
            retList.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            path.push(nums[i]);
            backTrack(retList, nums, path, i + 1, k);
            path.pop();
        }
    }
    
    @Test
    public void test() {
        List<List<Integer>> combine = combine(4, 2);
        for (List<Integer> integers : combine) {
            System.out.println(integers);
        }

    }

}
