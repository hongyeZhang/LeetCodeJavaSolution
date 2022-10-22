package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/15 21:06
 */
public class Test1011 {

    @Test
    public void test() {
        int[] weights = new int[]{1, 2, 3, 1, 1};
        int i = shipWithinDays(weights, 4);
        System.out.println(i);
    }


    @Test
    public void test2() {
        int[] weights = new int[]{1, 2, 3, 1, 1};
        int quantity = 2;
        int i = calculateDays(weights, quantity);
        System.out.println(i);
    }

    public int shipWithinDays(int[] weights, int days) {
        if (weights == null || weights.length == 0) {
            return 0;
        }
        int maxQuantity = 0;
        for (int weight : weights) {
            maxQuantity += weight;
        }
        int left = 1, right = maxQuantity, res = maxQuantity;
        while (left <= right) {
            int quantity = left + (right - left) / 2;
            int tmpDays = calculateDays(weights, quantity);
            if (tmpDays == -1) {
                left = quantity + 1;
            } else if (tmpDays == days) {
                res = Math.min(res, quantity);
                right = quantity - 1;
            } else if (tmpDays < days) {
                res = Math.min(res, quantity);
                right = quantity - 1;
            } else if (tmpDays > days) {
                left = quantity + 1;
            }
        }
        return res;
    }

    public int calculateDays(int[] weights, int totalQuantity) {
        int days = 0;
        int singleQuantity = 0;
        for (int weight : weights) {
            if (weight > totalQuantity) {
                return -1;
            }
            singleQuantity += weight;
            if (singleQuantity > totalQuantity) {
                days++;
                singleQuantity = weight;
            } else if (singleQuantity == totalQuantity) {
                days++;
                singleQuantity = 0;
            }
        }
        if (singleQuantity > 0) {
            days++;
        }
        return days;
    }

}
