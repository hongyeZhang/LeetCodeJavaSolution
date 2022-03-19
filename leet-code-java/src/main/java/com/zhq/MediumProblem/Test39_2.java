package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/15 13:04
 */
public class Test39_2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> retList = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(retList, track, candidates, target, 0, 0);
        return retList;
    }

    public void backTrack(List<List<Integer>> retList, LinkedList<Integer> track, int[] candidates, int target, int start, int tmpSum) {
        if (tmpSum == target) {
            retList.add(new LinkedList<>(track));
            return;
        }
        if (tmpSum > target) {
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            track.addLast(candidates[i]);
            // 这里 start = i 保证下一层的递归中，元素可以被重复选到
            backTrack(retList, track, candidates, target, i, tmpSum + candidates[i]);
            track.removeLast();
        }
    }


    @Test
    public void test() {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }



}
