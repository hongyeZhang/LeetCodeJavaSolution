package com.zhq.regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : ZHQ
 * @date : 2020/2/6
 */
public class Test2 {
    public static void main(String[] args) {
        test2();

    }

    public static void test1() {
        String content = "I am noob from runoob.com.";

        String regEx = ".*runoob.*";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println(content.substring(matcher.start(), matcher.end()));
        }

        boolean matches = Pattern.matches(regEx, content);
        System.out.println(matches);
    }

    public static void test2() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }

    }

    public static void test3() {
        String REGEX = "\\bcat\\b";
        String INPUT = "cat cat cat cattie cat";
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        int count = 0;

        while(m.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }

    }


}
