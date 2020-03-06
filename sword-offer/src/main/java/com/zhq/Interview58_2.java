package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/5
 */
public class Interview58_2 {
    public static String reverseLeftWords(String s, int n) {
        if (s.length() < 1) {
            return "";
        }

        int len = s.length();
        n %= len;
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        String input = "lrloseumgh";
        int n = 6;

        System.out.println(reverseLeftWords(input, 6));


    }

}
