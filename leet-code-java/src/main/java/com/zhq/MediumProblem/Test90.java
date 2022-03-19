package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/15 10:06
 */
public class Test90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> retList = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        backTrack(retList, track, nums, 0);
        return retList;
    }

    /**
     * 在求子集问题的基础上：一排序、二剪枝
     * @param retList
     * @param track
     * @param nums
     * @param start
     */
    public void backTrack(List<List<Integer>> retList, LinkedList<Integer> track, int[] nums, int start) {
        retList.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1]) {
                // 剪枝过程
                continue;
            }
            track.addLast(nums[i]);
            backTrack(retList, track, nums, i + 1);
            track.removeLast();
        }
    }


    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
