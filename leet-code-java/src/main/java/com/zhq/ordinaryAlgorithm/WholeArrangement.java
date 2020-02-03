package com.zhq.ordinaryAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 全排列算法
 *
 * @author : ZHQ
 * @date : 2020/2/2
 */
public class WholeArrangement {
    public static void main(String[] args) {

//        // first perm
//        int[] array = new int[]{1, 2, 3};
//        List<List<Integer>> result = new ArrayList<>();
//        perm(array, new Stack<>(), result);
//        System.out.println("first : ");
//        for (List<Integer> integers : result) {
//            System.out.println(integers);
//        }
//
//        // second perm
//        System.out.println("second : ");
//        secondPerm(array, 0, 2);

        // test
        testString();


    }

    public static void testString() {
        String[] inputArr = {"aa", "bb", "cc"};
        List<List<String>> result = new ArrayList<>();
        stringPerm(inputArr, new Stack<>(), result);

        List<String> combinationResult = new ArrayList<>();
        for (List<String> list : result) {
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append(s);
            }
            combinationResult.add(sb.toString());
        }
        System.out.println("combination result : ");
        for (String s : combinationResult) {
            System.out.print(s + "\t");
        }


    }


    /**
     * 在构造树的过程中dfs，将搜索到的节点入栈（回溯），栈的作用就是回溯，如果只是先序遍历那么打印的结果就是1，2，3 ； 3，2 … … 节点1不会重复打印，
     * 所以这块用栈来实现回溯，每访问一个节点，入栈，每回退一个节点，出栈，如果访问到的是叶子节点，那么直接输出栈中的所有元素，这样就实现了全排列。
     * 原文链接：https://blog.csdn.net/weixin_42220532/article/details/90900815
     *
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

    public static void stringPerm(String[] array, Stack<String> stack, List<List<String>> res) {
        if (array.length <= 0) {
            //进入了叶子节点，保存栈中内容
            List<String> tmpList = new ArrayList<>();
            tmpList.addAll(stack);
            res.add(tmpList);
        } else {
            for (int i = 0; i < array.length; i++) {
                //tmepArray是一个临时数组，用于就是 Ri
                //eg：1，2，3的全排列，先取出1，那么这时 tempArray 中就是 2，3
                String[] tempArray = new String[array.length - 1];
                System.arraycopy(array, 0, tempArray, 0, i);
                System.arraycopy(array, i + 1, tempArray, i, array.length - i - 1);
                stack.push(array[i]);
                stringPerm(tempArray, stack, res);
                stack.pop();
            }
        }
    }

    /**
     * 不停的递归，但是这里并没有减少数组中的元素，而是通过两个指针 start 和 end 来控制范围
     *
     * @param array
     * @param start
     * @param end
     */
    public static void secondPerm(int[] array, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = start; i <= end; i++) {
                // 1，2，3 的全排列这块相当于将其中一个提了出来，下次递归从 start+1 开始
                swap(array, start, i);
                secondPerm(array, start + 1, end);
                // 这块是复原数组，为了保证下次另外的同级递归使用数组不会出错
                // 这块可以通过树来理解，每次回退一步操作，交换回去
                swap(array, start, i);
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
