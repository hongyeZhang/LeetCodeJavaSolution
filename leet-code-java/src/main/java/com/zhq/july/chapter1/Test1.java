package com.zhq.july.chapter1;

/**
 * 字符串旋转
 * @author : ZHQ
 * @date : 2020/2/5
 */
public class Test1 {
    public static void main(String[] args) {
//        method1();
        method2();


    }

    public static void method1() {
        String input = "abcdef";
        String s = leftRotateString(input, 3);
        System.out.println(s);
    }

    /** 循环左移
     * @param inputStr
     * @param m 左移的位数
     */
    public static String leftRotateString(String inputStr, int m) {
        char[] chars = inputStr.toCharArray();
        for (int i = 0; i < m; ++i) {
            leftShiftOne(chars);
        }
        return String.valueOf(chars);
    }

    /** 左移一位
     * @param charArr
     */
    public static void leftShiftOne(char[] charArr) {
        int len = charArr.length;
        char first = charArr[0];
        for (int i = 1; i < len; ++i) {
            charArr[i - 1] = charArr[i];
        }
        charArr[len - 1] = first;
    }



    public static void method2() {
        String inputStr = "abcdef";
        System.out.println(leftRotateStringSecond(inputStr, 3));
    }

    /** 三步反转
     * @param inputStr
     * @param m
     * @return
     */
    public static String leftRotateStringSecond(String inputStr, int m) {
        int len = inputStr.length();
        m %= len;
        char[] chars = inputStr.toCharArray();
        reverseString(chars, 0, m - 1);
        reverseString(chars, m, len - 1);
        reverseString(chars, 0, len - 1);
        return String.valueOf(chars);
    }


    /** 反转字符串 [startIndex, endIndex]
     * @param chars
     * @param startIndex include
     * @param endIndex exclude
     */
    public static void reverseString(char[] chars, int startIndex, int endIndex) {
        // 测算
//        int medium = (startIndex + endIndex - 1) / 2 + 1;
//        for (int i = startIndex, j = endIndex; i < medium; ++i, --j) {
//            swap(chars, i, j);
//        }

        while (startIndex < endIndex) {
            swap(chars, startIndex++, endIndex--);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }











}
