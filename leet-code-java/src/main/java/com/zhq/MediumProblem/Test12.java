package com.zhq.MediumProblem;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : ZHQ
 * @date : 2020/1/30
 */
public class Test12 {

    static Map<Integer, String> map = new LinkedHashMap<>(16);
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }


    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }

    public static String intToRoman(int num) {
        if (num < 0 || num > 3999) {
            throw new IllegalArgumentException("illegal input");
        }

        int count = 0;
        String result = "";

        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if (num / key != 0) {
                count = num / key;
                num = num % key;
                if (count > 0) {
                    for (int i = 0; i < count; ++i) {
                        result += map.get(key);
                    }
                }
            }
        }
        return result;
    }
}
