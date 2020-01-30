package com.zhq.ordinaryAlgorithm;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-05-25 16:07
 **/
public class StringReverse {

    public static void main(String[] args) {

        System.out.println(reverse1("hello"));

        System.out.println(reverse2("hello"));


    }

    public static String reverse1(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverse2(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = str.length()- 1; i >= 0; --i) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void reverse3() {
        // 通过交换字符反转
        // 使用 堆栈


    }


}
