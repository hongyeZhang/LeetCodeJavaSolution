package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/5
 */
public class Interview58 {
    public static String reverseWords(String s) {
        if (s.length() < 1) {
            return "";
        }

        String[] inputArr = s.trim().split("\\s+");
        int leftIndex = 0;
        int rightIndex = inputArr.length - 1;
        while (leftIndex < rightIndex) {
            swap(inputArr, leftIndex++, rightIndex--);
        }
        StringBuilder sb = new StringBuilder("");
        for (String s1 : inputArr) {
            sb.append(s1+" ");
        }

        return sb.toString().trim();
    }

    public static void swap(String[] arr, int i, int j) {
        String tmp = arr[i].trim();
        arr[i] = arr[j].trim();
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        String str1 = "the sky is blue";
        String str2 = "  hello world!  ";
        String str3 = "a good   example";

//        reverseWords(str1);
//        reverseWords(str2);
        System.out.println(reverseWords(str3));



    }


}
