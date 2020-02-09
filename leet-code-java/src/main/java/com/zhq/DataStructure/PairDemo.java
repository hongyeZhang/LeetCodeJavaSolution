package com.zhq.DataStructure;

import javafx.util.Pair;

import java.io.PushbackInputStream;

/**
 * @author : ZHQ
 * @date : 2020/2/8
 */
public class PairDemo {
    public static void main(String[] args) {
        Pair<Integer, Integer> pair = new Pair<>(1, 4);



    }

    public static void test1() {
        Pair<String, String> pair = new Pair<>("hello", "world");
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());

        Pair<Integer, Integer> integerPair = new Pair<>(1, 3);
        System.out.println(integerPair.getKey());
        System.out.println(integerPair.getValue());
    }





}
