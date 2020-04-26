package com.interview;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/26
 */
public class Interview01_06 {

    public String compressString(String S) {
        if (null == S || S.length() == 0) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        char[] chars = S.toCharArray();
        char preChar = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] == preChar) {
                count++;
            } else {
                ret.append(preChar).append(count);
                preChar = chars[i];
                count = 1;
            }
        }
        ret.append(preChar).append(count);
        if (ret.length() >= S.length()) {
            return S;
        }

        return ret.toString();
    }

    @Test
    public void test() {
        String input = "abbccd";


        System.out.println(compressString(input));

    }








}
