package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/12 10:44
 */
public class Test438 {

    @Test
    public void test() {
        String s = "acdcaeccde";
        String p = "c";

        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }

    /**
     * 找字母异位词，滑动窗口算法
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return Collections.emptyList();
        }
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : pArr) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        Set<Integer> res = new HashSet<>();
        while (right < s.length()) {
            char r = sArr[right];
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (Objects.equals(window.get(r), need.get(r))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (need.size() == valid) {
                    res.add(left);
                }
                char l = sArr[left];
                left++;
                if (need.containsKey(l)) {
                    if (Objects.equals(need.get(l), window.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }

        }
        return new ArrayList<>(res);
    }


}
