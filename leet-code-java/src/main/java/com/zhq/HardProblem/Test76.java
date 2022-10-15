package com.zhq.HardProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    /**
     * 滑动窗口2
     * @param s
     * @param t
     * @return
     */
    public static String minWindowSecond(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : tArr) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // [left, right) 前闭后开区间
        int left = 0, right = 0, valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < sArr.length) {
            // 窗口右边移动
            char r = sArr[right];
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (Objects.equals(window.get(r), need.get(r))) {
                    valid++;
                }
            }

            // 窗口缩减
            while (valid == need.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                char l = sArr[left];
                left++;
                if (need.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = minWindowSecond(s, t);
        System.out.println(s1);

    }
}
