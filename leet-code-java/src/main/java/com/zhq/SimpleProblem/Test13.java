package com.zhq.SimpleProblem;

import java.util.LinkedHashMap;

/**
 * @author : ZHQ
 * @date : 2020/1/30
 */
public class Test13 {

    static LinkedHashMap<String, Integer> map = new LinkedHashMap<>(16);
    static {
        map.put("I", 1);
        map.put("IV", 3);
        map.put("IX", 8);
        map.put("V", 5);
        map.put("X", 10);
        map.put("XL", 30);
        map.put("XC", 80);
        map.put("L", 50);
        map.put("C", 100);
        map.put("CD", 300);
        map.put("CM", 800);
        map.put("D", 500);
        map.put("M", 1000);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));

    }


    /**
     * 两个字母的罗马符号，注意比原来的值要小一些
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int result = 0;
        if (s.length() == 1) {
            result = map.get(s);
        } else {
            result += map.get(s.substring(0, 1));
            for (int i = 2; i <= s.length(); ++i) {
                String one = s.substring(i - 1, i);
                String two = s.substring(i - 2, i);
                result += map.containsKey(two) ? map.get(two) : map.get(one);
            }
        }

        return result;
    }




}
