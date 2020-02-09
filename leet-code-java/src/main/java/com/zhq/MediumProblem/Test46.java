package com.zhq.MediumProblem;

import javafx.scene.chart.StackedAreaChart;
import sun.java2d.pipe.SpanIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/2/5
 */
public class Test46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> integers : permute) {
            System.out.println(integers);
        }


    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        perm(nums, new Stack<>(), res);
        return res;
    }


    /** 全排列
     * @param array
     * @param stack
     * @param res
     */
    public static void perm(int[] array, Stack<Integer> stack, List<List<Integer>> res) {
        if (array.length <= 0) {
            //进入了叶子节点，保存栈中内容
            List<Integer> tmpList = new ArrayList<>();
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
