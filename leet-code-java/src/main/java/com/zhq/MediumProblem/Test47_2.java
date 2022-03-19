package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/15 12:51
 */
public class Test47_2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(retList, track, nums, used);
        return retList;
    }

    /**
     * 在全排列的基础上增加了排序和剪枝
     * 通过保证元素的相对顺序不变来去重（这个思路需要好好理解一下）
     * @param retList
     * @param track
     * @param nums
     * @param used
     */
    public void backTrack(List<List<Integer>> retList, LinkedList<Integer> track, int[] nums, boolean[] used) {
        if (track.size() == nums.length) {
            retList.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            used[i] = true;
            backTrack(retList, track, nums, used);
            track.removeLast();
            used[i] = false;
        }
    }


    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }



}
