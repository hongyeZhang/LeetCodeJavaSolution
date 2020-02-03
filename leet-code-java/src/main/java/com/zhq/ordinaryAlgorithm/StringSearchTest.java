package com.zhq.ordinaryAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/2/2
 */
public class StringSearchTest {
    public static void main(String[] args) {
        String str = "ABABD";
        String key = "AB";
        List<Integer> res = searchAllIndex(str, key);
        for (Integer re : res) {
            System.out.print(re + "\t");
        }

    }

    public static List<Integer> searchAllIndex(String str, String key) {
        List<Integer> res = new ArrayList<>();
        int index = str.indexOf(key);
        while (index != -1) {
            res.add(index);
            index = str.indexOf(key, index + 1);
        }
        return res;
    }



}
