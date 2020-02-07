package com.zhq.july.chapter1;

import java.util.Arrays;

/**
 * @author : ZHQ
 * @date : 2020/2/6
 */
public class Test1_2 {
    public static void main(String[] args) {
        String str = "i am a student.";
        System.out.println(reverseWord(str));
    }

    public static String reverseWord(String inputStr) {
        String[] wordArr = inputStr.split(" ");
        int startIndex = 0;
        int endIndex = wordArr.length - 1;
        while (startIndex < endIndex) {
            swap(wordArr, startIndex++, endIndex--);
        }
        return String.join(" ", Arrays.asList(wordArr));
    }

    public static void swap(String[] inputArr, int i, int j) {
        String tmp = inputArr[i];
        inputArr[i] = inputArr[j];
        inputArr[j] = tmp;
    }


}
