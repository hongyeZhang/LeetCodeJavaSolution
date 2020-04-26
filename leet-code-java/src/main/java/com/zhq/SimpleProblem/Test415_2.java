package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/26
 */
public class Test415_2 {

    public String addStrings(String num1, String num2) {
        if (null == num1 && null == num2) {
            return "";
        } else if (null == num1) {
            return num2;
        } else if (null == num2) {
            return num1;
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 > len2 ? len1 + 1 : len2 + 1;
        int[] result = new int[len];
        char[] arr1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] arr2 = new StringBuilder(num2).reverse().toString().toCharArray();
        for (int i = 0; i < len; ++i) {
            int a = i < len1 ? (int) arr1[i] - '0' : 0;
            int b = i < len2 ? (int) arr2[i] - '0' : 0;
            result[i] = a + b;
        }

        for (int i = 0; i < result.length; ++i) {
            if (result[i] >= 10) {
                result[i + 1] += 1;
                result[i] = result[i] % 10;
            }
        }

        StringBuilder ret = new StringBuilder();
        boolean flag = true;
        for (int i = result.length - 1; i >= 0; --i) {
            if (result[i] == 0 && flag) {
                // 去掉不应该展示的0
                continue;
            } else {
                flag = false;
            }
            ret.append(result[i]);
        }

        // 校验0的输入情况
        if (ret.toString().isEmpty()) {
            ret.append("0");
        }
            return ret.toString();
        }

    @Test
    public void test() {
        String num1 = "0";
        String num2 = "0";
        System.out.println(addStrings(num1, num2));
    }



}
