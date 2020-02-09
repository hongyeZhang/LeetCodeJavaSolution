package com.zhq.MediumProblem;

import com.zhq.util.CharUtil;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-05-19 16:27
 **/
public class TempTest {

    public static void main(String[] args) {
        int k = 2;
        char[] chars = new char[]{'1', '2', '3', '4', '5'};
        CharUtil.printCharArray(chars);

        int len = chars.length;
        char[] newArray = new char[len];
        System.arraycopy(chars, len - k, newArray, 0, k);
        System.arraycopy(chars, 0, newArray, k, len - k);
        System.out.println();
        CharUtil.printCharArray(newArray);





    }




}
