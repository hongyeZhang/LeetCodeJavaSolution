package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/15 10:27
 */
public class Test40_2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> retList = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);
        backTrack(retList, track, candidates, target, 0, 0);
        return retList;
    }

    public void backTrack(List<List<Integer>> retList, LinkedList<Integer> track, int[] candidates, int target, int start, int tmpSum) {
        if (target == tmpSum) {
            retList.add(new LinkedList<>(track));
            return;
        }
        if (tmpSum > target) {
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            track.addLast(candidates[i]);
            backTrack(retList, track, candidates, target, i + 1, tmpSum + candidates[i]);
            track.removeLast();
        }
    }

    @Test
    public void test() {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> lists = combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
