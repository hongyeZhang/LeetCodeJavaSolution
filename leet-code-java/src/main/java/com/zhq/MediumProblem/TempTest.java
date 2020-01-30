package com.zhq.MediumProblem;

import java.util.*;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-05-19 16:27
 **/
public class TempTest {

    public static void main(String[] args) {

        Map<Integer, String> map = new LinkedHashMap<>(16);
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

        Set<Integer> integers = map.keySet();
        System.out.println(integers);


    }
}
