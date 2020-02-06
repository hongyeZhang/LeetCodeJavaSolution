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

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        perm(nums, new Stack<>(), res);
        return res;
    }

    public static void perm(int[] array, Stack<Integer> stack, List<List<Integer>> res) {
        if (array.length <= 0) {
            //进入了叶子节点，保存栈中内容
            List<Integer> tmpList = new ArrayList<>();
            // TODO: 2020/2/5
            tmpList.addAll(stack);
            res.add(tmpList);
        } else {
            for (int i = 0; i < array.length; i++) {
                //tmepArray是一个临时数组，用于就是 Ri
                //eg：1，2，3的全排列，先取出1，那么这时 tempArray 中就是 2，3
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
