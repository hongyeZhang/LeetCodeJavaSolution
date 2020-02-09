package com.zhq.SimpleProblem;

import com.zhq.util.IntUtil;

import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class Test66 {

    /** 思路有问题，对数组的长度有严格的限制
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        return transferIntegerToIntArray(transferIntArrToInteger(digits) + 1);
    }

    public static int[] transferIntegerToIntArray(int input) {
        Stack<Integer> stack = new Stack<>();
        while (input > 0) {
            stack.push(input % 10);
            input /= 10;
        }

        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }

        return res;
    }


    public static int transferIntArrToInteger(int[] inputArr) {
        int ret = 0;
        for (int i : inputArr) {
            ret = ret * 10 + i;
        }
        return ret;
    }


    public static void main(String[] args) {
        int input = 123;
//        int[] inputArr = new int[]{1, 2, 3};
        int[] inputArr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        IntUtil.printIntArray(plusOne(inputArr));

    }


}
