package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/26 16:54
 */
public class Test494 {

    /**
     * 回溯算法超时
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<List<Integer>> retList = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(retList, track, nums, 0, 0, target);
        return retList.size();
    }

    public void backTrack(List<List<Integer>> retList, LinkedList<Integer> track, int[] nums, int start, int curSum, int target) {
        if (track.size() == nums.length) {
            if (curSum == target) {
                retList.add(new LinkedList<>(track));
            }
            return;
        }
        for (int i = 0; i < 2; ++i) {
            if (i == 0) {
                track.addLast(nums[start]);
                backTrack(retList, track, nums, start + 1, curSum + nums[start], target);
                track.removeLast();
            } else {
                track.addLast(-nums[start]);
                backTrack(retList, track, nums, start + 1, curSum - nums[start], target);
                track.removeLast();
            }
        }
    }


    @Test
    public void test() {
        int[] nums = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        int target = 1;
        int targetSumWays = findTargetSumWays(nums, target);
        System.out.println(target);
    }

}
