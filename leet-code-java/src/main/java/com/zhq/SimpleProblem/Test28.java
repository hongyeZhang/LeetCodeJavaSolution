package com.zhq.SimpleProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/1
 */
public class Test28 {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
        System.out.println(naiveStrCompare(haystack, needle));

    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /** BF算法，暴力算法
     * @param haystack
     * @param needle
     * @return
     */
    public static int naiveStrCompare(String haystack, String needle) {
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                // 条件不满足，则进行回溯，通过找规律可得，每次i的回溯位置都是i-j+1, j每次都回溯到0的位置
                i = i - j + 1;
                j = 0;
            }
        }
        return j >= needle.length() ? i - j : -1;
    }

}
