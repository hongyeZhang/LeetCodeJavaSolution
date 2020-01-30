package com.zhq.MediumProblem;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @program: LeetCodeTest
 * @description: 字符串转化整数
 * @author: ZHQ
 * @create: 2019-05-20 23:13
 **/
public class Test8 {

    public static void main(String[] args) {


        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("  -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("+"));
        System.out.println(myAtoi(" 0000000000000 "));
        System.out.println(myAtoi("+-2"));
        System.out.println(myAtoi(" +0a32"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("20000000000000000000"));

    }


    public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        } else if (str.length() == 1) {
            if (isNumber(str.charAt(0))) {
                return Integer.valueOf(str);
            }
            return 0;
        } else {
            // 长度大于2
            char firstChar = str.charAt(0);
            char sign = ' ';
            if ('+' != firstChar && '-' != firstChar && !isNumber(firstChar)) {
                return 0;
            } else if (!isNumber(firstChar)) {
                sign = firstChar;
                str = str.substring(1, str.length());
                if (!isNumber(str.charAt(0))) {
                    return 0;
                }
            }

            // 现在开头肯定是数字
            String retStr = "";
            StringBuilder tempSb = new StringBuilder("");
            // 去掉开头多余的0
            while (str.length() > 0 && '0' == str.charAt(0)) {
                str = str.substring(1, str.length());
            }
            if (str.length() == 0 || (str.length() > 0 && !isNumber(str.charAt(0)))) {
                return 0;
            }

            // 开头肯定是非0数字或者字符
            while (str.length() > 0 && isNumber(str.charAt(0))) {
                tempSb.append(str.charAt(0));
                str = str.substring(1, str.length());
            }

            if ('-' == sign) {
                retStr = "-" + tempSb.toString();
            } else {
                retStr = tempSb.toString();
            }

            if (tempSb.toString().length() > String.valueOf(Integer.MIN_VALUE).length()) {
                if ('-' == sign) {
                    return Integer.MIN_VALUE;
                } else if (' ' == sign || '+' == sign) {
                    return Integer.MAX_VALUE;
                }
            }

            //将字符串转化整数
            Long temp = Long.parseLong(retStr);
            if (temp <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (temp >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.valueOf(retStr);
            }
        }

        // over
    }

    public static boolean isNumber(char input) {
        return (int)'0' <= (int) input && (int)'9' >= (int) input;
    }

    public static void test() {
        // 通过将字符强制转换为int输出ascii码
        // 数字的范围是 48 - 57
        String str = "0123456789";
        for (int i = 0; i < str.length(); ++i) {
            System.out.println((int)str.charAt(i));
        }
    }

}
