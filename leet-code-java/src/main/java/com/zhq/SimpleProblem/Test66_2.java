package com.zhq.SimpleProblem;

import com.zhq.util.IntUtil;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class Test66_2 {

    /** 情况比较复杂，多分支容易出错
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        // 不存在进位的情况
        int firstSum = digits[len - 1] + 1;
        if (firstSum < 10) {
            digits[len - 1] = firstSum;
            return digits;
        }

        // 处理存在进位的情况
        int[] res = new int[len + 1];
        res[len] = 0;
        // 输入数组只有一位
        if (len == 1) {
            res[0] = 1;
            return res;
        }

        // 两位以上的数组
        for (int i = len - 2; i >= 0; --i) {
            int tmpRes= digits[i] + 1;
            if (tmpRes == 10) {
                res[i + 1] = 0;
            } else {
                // 不存在进位，新数组一定与原有的数组等长
                res[i + 1] = tmpRes;
                for (int k = 0; k < i; ++k) {
                    res[k + 1] = digits[k];
                }
                break;
            }
            if (i == 0) {
                res[0] = 1;
            }
        }

        if (res[0] == 1) {
            return res;
        }
        int[] trueRes = new int[len];
        System.arraycopy(res, 1, trueRes, 0, len);
        return trueRes;
    }




    public static void main(String[] args) {
//        int[] digits = {4, 3, 2, 1};
//        int[] digits = {1, 2, 3};
//        int[] digits = {9, 9, 9};
//        int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        int[] digits = {9};
//        int[] digits = {8, 9, 9, 9};
        int[] digits = {2, 4, 9, 3, 9};
        int[] ints = plusOne(digits);
        IntUtil.printIntArray(ints);


    }

}
