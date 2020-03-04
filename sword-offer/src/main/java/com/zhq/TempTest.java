package com.zhq;

import java.util.LinkedHashMap;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class TempTest {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("C", "3");

        for (String s : map.keySet()) {
            System.out.println(s);
        }




    }



}
