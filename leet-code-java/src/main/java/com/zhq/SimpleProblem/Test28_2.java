package com.zhq.SimpleProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/1
 */
public class Test28_2 {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(kmpSearch(haystack, needle));
    }

    /** 通过 KMP 算法实现，实现了主体算法，但是没有对边界条件做处理
     *  参考链接
     *  https://blog.csdn.net/v_july_v/article/details/7041827
     * @param haystack
     * @param needle
     * @return
     */
    public static int kmpSearch(String haystack, String needle) {
        // 计算next数组
        int[] next = new int[needle.length()];
        getNextArray(needle.toCharArray(), next);

        int i = 0;
        int j = 0;
        int eLen = haystack.length();
        int pLen = needle.length();
        while (i < eLen && j < pLen) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }

        return j == needle.length() ? i - j : -1;
    }

    /** 计算模式串的 next数组
     * @param p
     * @param next
     */
    public static void getNextArray(char[] p, int[] next) {
        int len = p.length;
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < len - 1) {
            if (k == -1 || p[j] == p[k]) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }

}
