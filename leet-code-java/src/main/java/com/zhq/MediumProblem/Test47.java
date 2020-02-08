package com.zhq.MediumProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/2/5
 */
public class Test47 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        perm(nums, new Stack<>(), res);
        return res;
    }

    /** 在全排列的基础上增加去重的功能
     * @param array
     * @param stack
     * @param res
     */
    public static void perm(int[] array, Stack<Integer> stack, List<List<Integer>> res) {
        if (array.length <= 0) {
            // 进入了叶子节点，保存栈中内容
            List<Integer> tmpList = new ArrayList<>();
            tmpList.addAll(stack);
            // 排出重复的组合
            boolean addFlag = true;
            for (int i = 0; i < res.size(); ++i) {
                if (tmpList.equals(res.get(i))) {
                    addFlag = false;
                }
            }
            if (addFlag) {
                res.add(tmpList);
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                int[] tempArray = new int[array.length - 1];
                System.arraycopy(array, 0, tempArray, 0, i);
                System.arraycopy(array, i + 1, tempArray, i, array.length - i - 1);
                stack.push(array[i]);
                perm(tempArray, stack, res);
                stack.pop();
            }
        }
    }

}
