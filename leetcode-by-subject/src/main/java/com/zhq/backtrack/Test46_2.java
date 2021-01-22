package com.zhq.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZHQ
 * @Date: 2020/12/16
 */
public class Test46_2 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return Collections.emptyList();
        }

        List<List<Integer>> retList = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, retList);
        return retList;
    }


    public void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> retList) {
        if (track.size() == nums.length) {
            retList.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track, retList);
            track.removeLast();
        }
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
