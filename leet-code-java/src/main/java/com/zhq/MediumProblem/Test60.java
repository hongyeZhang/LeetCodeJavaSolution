package com.zhq.MediumProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class Test60 {

    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        System.out.println(getPermutation(n, k));
    }

    /** 全排列的基础上取低k个元素，但是 超时 了
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        int[] inputArr = new int[n];
        for (int i = 0; i < n; ++i) {
            inputArr[i] = i + 1;
        }
        List<List<Integer>> res = new ArrayList<>();
        perm(inputArr, new Stack<>(), res);

        // 将序列转化为数字
//        List<Integer> integerList = new ArrayList<>();
//        for (List<Integer> re : res) {
//            int tmpData = 0;
//            for (int i = 0; i < re.size(); ++i) {
//                tmpData = 10 * tmpData + re.get(i);
//            }
//            integerList.add(tmpData);
//        }
//        Collections.sort(integerList);
//        return String.valueOf(integerList.get(k-1));

        List<Integer> list = res.get(k - 1);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return sb.toString();
    }

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
