package com.zhq.HardProblem;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/18 09:53
 */
public class Test76 {


    /**
     * 滑动窗口解法
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int[] tFreq = new int[128];
        int[] winFreq = new int[128];
        for (int i = 0; i < tCharArray.length; ++i) {
            tFreq[tCharArray[i]]++;
        }

        // [l,r) 前闭后开区间
        int l = 0, r = 0;
        int minLen = s.length() + 1, minL = 0;
        int distance = 0;
        while (r < s.length()) {
            if (tFreq[sCharArray[r]] > 0) {
                winFreq[sCharArray[r]]++;
                if (winFreq[sCharArray[r]] <= tFreq[sCharArray[r]]) {
                    distance++;
                }
            }
            r++;
            while (distance == t.length()) {
                if (minLen > r - l) {
                    minLen = r - l;
                    minL = l;
                }
                if (tFreq[sCharArray[l]] > 0) {
                    winFreq[sCharArray[l]]--;
                    if (winFreq[sCharArray[l]] < tFreq[sCharArray[l]]) {
                        distance--;
                    }
                }
                l++;
            }
        }
        return minLen > s.length() ? "" : s.substring(minL, minL + minLen);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = minWindow(s, t);
        System.out.println(s1);

    }
}
