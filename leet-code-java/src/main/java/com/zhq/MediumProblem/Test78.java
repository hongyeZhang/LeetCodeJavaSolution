package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/14 19:11
 */
public class Test78 {

    /**
     * 求子集问题，注意不要添加重复的元素，通过每一层的 start 起点来进行控制
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> retList = new LinkedList<>();
        Stack<Integer> track = new Stack<>();
        backTrack(nums, 0, retList, track);
        return retList;
    }

    public void backTrack(int[] nums, int start, List<List<Integer>> retList, Stack<Integer> track) {
        retList.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; ++i) {
            track.add(nums[i]);
            backTrack(nums, i + 1, retList, track);
            track.pop();
        }
    }



    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

}
