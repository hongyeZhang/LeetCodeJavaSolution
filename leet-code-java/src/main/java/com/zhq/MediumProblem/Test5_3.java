package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/14 09:40
 */
public class Test5_3 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length(); ++i) {
            String oddPalinrome = findPalindrome(s, i, i);
            if (oddPalinrome.length() > res.length()) {
                res = oddPalinrome;
            }
            String evenPalinrome = findPalindrome(s, i, i + 1);
            if (evenPalinrome.length() > res.length()) {
                res = evenPalinrome;
            }
        }
        return res;
    }


    /**
     * 回文串的的长度可能是奇数也可能是偶数，解决该问题的核心是从中心向两端扩散的双指针技巧
     * 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
     * @param s
     * @param left
     * @param right
     * @return
     */
    public String findPalindrome(String s, int left, int right) {
        while (left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    @Test
    public void test() {
        String out = longestPalindrome("babad");
        System.out.println(out);
    }

}
