package com.zhq.MediumProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCodeTest
 * @description: 无重复字符的最长子串
 * @author: ZHQ
 * @create: 2018-10-21 17:37
 **/
public class Test3 {

    /**
     * @Description: 暴力求解算法，空间复杂度O(n)，时间复杂度O(n^3)
     * @Param: [s]
     * @return: int
     * @Author: ZHQ
     * @Date: 2018/10/21
     **/
    public static int lengthOfLongestSubstring2(String s) {
        //枚举所有的子串
        int maxLength = 0;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i + 1; j < s.length() + 1; ++j) {
                if (isUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;
    }

    /**
     * [start,end)
     *
     * @param s
     * @param start include
     * @param end   exclude
     * @return
     */
    public static boolean isUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; ++i) {
            Character c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }


    /**
     * @Description: 滑动窗口方法，时间复杂度0(n^2),空间复杂度O(n)
     * @Param: [s]
     * @return: int
     * @Author: ZHQ
     * @Date: 2018/10/21
     **/
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0, n = s.length(), i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        String input = "pwwkew";
        System.out.println(lengthOfLongestSubstring(input));
    }
}
