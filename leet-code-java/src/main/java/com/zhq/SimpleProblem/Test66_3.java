package com.zhq.SimpleProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/10
 */
public class Test66_3 {

    /** leetcode 精选题解，真TM秒啊
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0){ return digits;}

        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
