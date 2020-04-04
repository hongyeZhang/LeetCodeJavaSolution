package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/3
 */
public class Test5_2 {

    private int palindromeStartIndex = 0;

    private int palindromeMaxLen = 0;

    /** 最长回文子串
     *  以某个元素为中心，分别计算偶数长度的回文最大长度和奇数长度的回文最大长度。
     *  =============================================================================================
     * @param s
     * @return
     */
    public String longestPalindromeStr(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); ++i) {
            longestPalindromeHelper(s, i, i);
            longestPalindromeHelper(s, i, i+1);
        }

        return s.substring(palindromeStartIndex, palindromeStartIndex + palindromeMaxLen);
    }

    public void longestPalindromeHelper(String input, int left, int right) {
        while (left >= 0 && right < input.length() && (input.charAt(left) == input.charAt(right))) {
            left--;
            right++;
        }
        if (palindromeMaxLen < right - left - 1) {
            palindromeStartIndex = left + 1;
            palindromeMaxLen = right - left - 1;
        }
    }


    @Test
    public void testLongestPalindromeHelper() {
        String input = "babad";
        String s = longestPalindromeStr(input);
        System.out.println(s);
    }

}
