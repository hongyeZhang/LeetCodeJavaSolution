package com.zhq.SimpleProblem;

import java.util.LinkedHashMap;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-05-19 22:18
 **/
public class TempTest {

    public static void main(String[] args) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        map.put('a', 1);
        map.put('b', 2);
        map.put('a', map.get('a') + 1);

        System.out.println(map);




    }
}
