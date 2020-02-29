package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/2/29
 */
public class Interview05 {

    public static String replaceSpace(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        int len = s.length();
        StringBuilder out = new StringBuilder("");
        String[] splitArr = s.split(" ");
        if (splitArr.length == 1) {
            out.append(splitArr[0]);
        }  else {
            int i = 0;
            while (i < splitArr.length - 1) {
                out.append(splitArr[i++] + "%20");
            }
            out.append(splitArr[i]);
        }

        if (s.charAt(len - 1) == ' ') {
            out.append("%20");
        }
        return out.toString();
    }

    public static String replaceSpace2(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        StringBuilder out = new StringBuilder("");
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                out.append("%20");
            } else {
                out.append(s.charAt(i));
            }
        }
        return out.toString();
    }




    public static void main(String[] args) {
        String input = "We are happy";
        String input2 = "We are happy ";
        String input3 = "   ";

        System.out.println(replaceSpace2(input));
        System.out.println(replaceSpace2(input2));
        System.out.println(replaceSpace2(input3));






    }
}
