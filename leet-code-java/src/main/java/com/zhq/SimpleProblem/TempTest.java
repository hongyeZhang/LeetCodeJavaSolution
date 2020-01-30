package com.zhq.SimpleProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-05-19 22:18
 **/
public class TempTest {

    public static void main(String[] args) {
        for (int i = 0; i < 5; ++i) {
            System.out.println("i = " + i);
            for (int j = 0; j < 5; ++j) {
                System.out.println("j=" + j);
                if (j == 1) {
                    break;
                }
            }
        }


    }
}
