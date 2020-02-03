package com.zhq.MediumProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeTest
 * @description: 组合总和
 * @author: ZHQ
 * @create: 2019-06-15
 **/
public class Test39 {

    public static void main(String[] args) {

        int[] input = {2, 3, 6, 7};
        Test39 test39 = new Test39();

        List<List<Integer>> list = test39.combinationSum(input, 7);
        list.forEach(System.out::println);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        return combinationSum(candidates, target, 0, candidates.length - 1);

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<Integer>());
        return res;
    }

    /**
     * @Description: 两种情况分析
     * @Param:
     * @return:
     * @Author: ZHQ
     * @Date: 2019-06-15
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target, int begin, int end) {
        List<List<Integer>> list = new ArrayList<>();

        if (begin <= end) {
            int cur = candidates[begin];
            if (cur == target) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(cur);
                list.add(list1);
            }
            if (cur < target) {
                for (List<Integer> list1 : combinationSum(candidates, target - cur, begin, end)) {
                    list1.add(cur);
                    list.add(list1);
                }
                list.addAll(combinationSum(candidates, target, begin + 1, end));
            }
        }
        return list;
    }

    /**
    * @Description:  标准回溯算法
    * @Param:
    * @return:
    * @Author: ZHQ
    * @Date: 2019-06-15
    */
    private void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0){ return;}
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if (target < candidates[start]){ break;}
            tmp_list.add(candidates[start]);
            backtrack(candidates, target - candidates[start], res, start, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }


}
