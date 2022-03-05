package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/19 11:43
 */
public class Test680 {

    /**
     * 双指针
     * 如果只能删除一个字符，那么就分别判断删除任何一种字符的处理方式
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char low = s.charAt(i);
            char high = s.charAt(j);
            if (low != high) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i <= j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test() {
        String input = "abca";
        boolean b = validPalindrome(input);
        System.out.println(b);
    }
}
