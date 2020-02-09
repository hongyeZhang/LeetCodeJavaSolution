package com.zhq.SimpleProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class Test58 {
    public static void main(String[] args) {
        String input = "Hello World";
        System.out.println(lengthOfLastWord(input));


    }

    public static int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        s = s.trim();
        String[] strArr = s.split(" ");
        String lastWord = strArr[strArr.length - 1];

        return lastWord.length();
    }
}
