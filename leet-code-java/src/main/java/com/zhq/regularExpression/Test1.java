package com.zhq.regularExpression;

import java.util.ConcurrentModificationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-05-25 15:43
 **/
public class Test1 {

    public static void main(String[] args) {

        System.out.println(patternTest1("+234hhh"));
        System.out.println(patternTest1("+000234hhh"));
        System.out.println(patternTest1("hhhhh"));

    }


    public static String patternTest1(String str) {
        String ret = null;
        // 符号或者数字开头的数字字符串
        String regEx = "^[\\+\\-\\d]\\d*";
        Pattern pattern = Pattern.compile(regEx);
        Matcher m = pattern.matcher(str);
        if (m.find()) {
            ret = str.substring(m.start(), m.end());
        }

        return ret;
    }
}
