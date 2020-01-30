package com.zhq.SimpleProblem;

/**
 * @program: LeetCodeTest
 * @description: 回文数
 * @author: ZHQ
 * @create: 2019-05-25 15:52
 **/
public class Test9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(12333));
    }

    // 官方注释


    /** 转化为数组进行判断
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        // 正数：判断回文
        String str = String.valueOf(x);
        int len = str.length();
        for (int i = 0; i < len / 2; ++i) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
