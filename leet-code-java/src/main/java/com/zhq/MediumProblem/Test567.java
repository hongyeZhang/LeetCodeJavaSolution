package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/12 10:23
 */
public class Test567 {


    @Test
    public void test() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean ret = checkInclusion(s1, s2);
        System.out.println(ret);
    }


    /**
     * 判断 s2 中是否包含 s1
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return false;
        }
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // init need
        for (char c : s1Arr) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char r = s2Arr[right];
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (Objects.equals(window.get(r), need.get(r))) {
                    valid++;
                }
            }
            // 通过窗口的大小控制，保证进行判断的区间一定是个连续的子串
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    // 找到字符串
                    return true;
                }
                char l = s2Arr[left];
                left++;
                if (need.containsKey(l)) {
                    if (Objects.equals(window.get(l), need.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return false;
    }
}
