package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/3
 */
public class Tst151 {

    public String reverseWords(String s){
        if (s.trim().length() == 0) {
            return s.trim();
        }
        String[] split = s.trim().split(" +");
        String ret = "";
        for (int i = split.length - 1; i > 0; i--) {
            ret += split[i] + " ";
        }
        return ret + split[0];
    }

    @Test
    public void test() {
        String input = "the sky is blue";



    }

}
