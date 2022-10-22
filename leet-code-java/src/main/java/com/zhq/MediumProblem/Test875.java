package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/15 20:34
 */
public class Test875 {


    @Test
    public void test() {
        int[] piles = new int[]{30, 11, 23, 4, 20};
        int h = 6;
        System.out.println(minEatingSpeed(piles, h));
    }

    @Test
    public void test2() {
        int[] piles = new int[]{3, 6, 7, 11};
        int i = calculateTime(piles, 7);
        System.out.println(i);
    }

    /**
     * 根据题目确定吃香蕉速度的上界和下界，再用二分法搜索吃掉所有香蕉的最小速度
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) {
            return 0;
        }
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(pile, maxPile);
        }
        int left = 1, right = maxPile, minSpeed = maxPile;
        while (left <= right) {
            // 寻找最左边的边界
            int speed = left + (right - left) / 2;
            int time = calculateTime(piles, speed);
            if (time < h) {
                minSpeed = Math.min(minSpeed, speed);
                right = speed - 1;
            } else if (time == h) {
                minSpeed = Math.min(minSpeed, speed);
                right = speed - 1;
            } else if (time > h) {
                left = speed + 1;
            }
        }
        return minSpeed;
    }

    public int calculateTime(int[] piles, int speed) {
        int time = 0;
        for (int pile : piles) {
            time += Math.ceil((double) pile / (double) speed);
        }
        return time;
    }

}
