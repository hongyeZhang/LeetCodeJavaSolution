package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/26
 */
public class Test344 {

    public void reverseString(char[] s) {
        if (null == s || s.length < 2) {
            return;
        }
        int len = s.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }


    @Test
    public void test() {
        char[] chars = new char[] {'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
        for (char aChar : chars) {
            System.out.print(aChar + "\t");
        }
    }


}
