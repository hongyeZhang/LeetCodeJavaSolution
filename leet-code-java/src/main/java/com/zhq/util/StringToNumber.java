package com.zhq.util;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-05-25 14:42
 **/
public class StringToNumber {

    public static void main(String[] args) {

        testStringToInt();

    }


    /**
     * @Description: 溢出时分别返回最大最小值
     * @Param: [str]  由数字组成的字符串
     * @return: int
     * @Author: ZHQ
     * @Date: 2019/5/25
     **/
    public static int stringToInt(String str) {
        int ret = 0;
        boolean isNegative = false;

        if ('-' == str.charAt(0)) {
            isNegative = true;
            str = str.substring(1);
        }

        for (int index = 0; index < str.length(); ++index) {
            int currentNum = str.charAt(index) - '0';
            if (isNegative) {
                if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && currentNum > Math.abs(Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
                }
                ret = ret * 10 - currentNum;
            } else {
                if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && currentNum > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                ret = ret * 10 + currentNum;
            }
        }

        return ret;
    }

    public static int stringToIntV2(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            if (str.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void testStringToInt() {
        System.out.println("input = " + "-123" + "\t" + "output = " + stringToInt("-123"));
        System.out.println("input = " + "123" + "\t" + "output = " + stringToInt("123"));
        System.out.println("input = " + "2147483647" + "\t" + "output = " + stringToInt("2147483647"));
        System.out.println("input = " + "2147483648" + "\t" + "output = " + stringToInt("2147483648"));
        System.out.println("input = " + "-2147483648" + "\t" + "output = " + stringToInt("-2147483648"));
        System.out.println("input = " + "-2147483649" + "\t" + "output = " + stringToInt("-2147483649"));

        System.out.println("============  test v2  ==============");

        System.out.println("input = " + "-123" + "\t" + "output = " + stringToIntV2("-123"));
        System.out.println("input = " + "123" + "\t" + "output = " + stringToIntV2("123"));
        System.out.println("input = " + "2147483647" + "\t" + "output = " + stringToIntV2("2147483647"));
        System.out.println("input = " + "2147483648" + "\t" + "output = " + stringToIntV2("2147483648"));
        System.out.println("input = " + "-2147483648" + "\t" + "output = " + stringToIntV2("-2147483648"));
        System.out.println("input = " + "-2147483649" + "\t" + "output = " + stringToIntV2("-2147483649"));
    }
}
