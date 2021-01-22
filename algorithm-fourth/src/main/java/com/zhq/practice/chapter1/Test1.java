package com.zhq.practice.chapter1;

import org.junit.Test;

/**
 * @Author: ZHQ
 * @Date: 2020/12/13
 */
public class Test1 {

    @Test
    public void test1() {
        System.out.println(calculateMaxCommonDivisor(15, 30));
        System.out.println(calculateMaxCommonDivisor(30, 15));

    }


    /**
     * 最大公约数
     * @param p
     * @param q
     * @return
     */
    public int calculateMaxCommonDivisor(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return calculateMaxCommonDivisor(q, r);
    }




}
