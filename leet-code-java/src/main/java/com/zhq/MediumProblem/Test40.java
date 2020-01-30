package com.zhq.MediumProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeTest
 * @description: 组合总和 II
 * @author: ZHQ
 * @create: 2019-06-15
 **/
public class Test40 {

    public static void main(String[] args) {

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        Test40 test40 = new Test40();
//        List<List<Integer>> res = test40.combinationSum2(candidates, target);
        List<List<Integer>> res = test40.combinationSum3(candidates, target);
        res.forEach(item->{
            System.out.println(item);
        });


    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack2(candidates, target, res, 0, new ArrayList<>());
        return res;
    }





    /**
    * @Description:  与39题一致
    * @Param:
    * @return:
    * @Author: ZHQ
    * @Date: 2019-06-15
    */
    public void backTrack2(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if (start > i && candidates[start] == candidates[start - 1]) {
                continue;
            }
            if (target < candidates[start]) break;
            tmp_list.add(candidates[start]);
            backTrack2(candidates, target - candidates[start], res, start+1, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int target, int i, int tmp_sum, ArrayList<Integer> tmp_list) {
        if (tmp_sum == target) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if (tmp_sum + candidates[start] > target) break;
            if (start > i && candidates[start] == candidates[start - 1]) continue;
            tmp_list.add(candidates[start]);
            backtrack(res, candidates, target, start + 1, tmp_sum + candidates[start], tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }








}
