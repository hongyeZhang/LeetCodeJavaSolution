package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/26
 */
public class Test43_2 {

    public String multiply(String num1, String num2) {
        if (null == num1 || null == num2 || num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        char[] arr1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] arr2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] result = new int[len1 + len2];
        for (int i = 0; i < len1; ++i) {
            for (int j = 0; j < len2; ++j) {
                int a = (int) arr1[i] - '0';
                int b = (int) arr2[j] - '0';
                result[i + j] += a * b;
            }
        }

        // 处理进位
        for (int i = 0; i < result.length - 1; ++i) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] = result[i] % 10;
            }
        }

        StringBuilder ret = new StringBuilder();
        boolean zeroFlag = true;
        for (int i = result.length - 1; i >= 0; --i) {
            if (result[i] == 0 && zeroFlag) {
                continue;
            } else {
                zeroFlag = false;
            }
            ret.append(result[i]);
        }

        return ret.toString();
    }

    @Test
    public void test() {
        String str1 = "123";
        String str2 = "456";
        System.out.println(multiply(str1, str2));
    }







}
