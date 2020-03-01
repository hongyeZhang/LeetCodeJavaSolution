package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class Interview14 {

    public static int cuttingRope(int n) {
        return maxProductAfterCutting(n);

    }

    public static int maxProductAfterCutting(int length) {
        if (length < 2) {
            return 0;
        } else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }

        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; ++i) {
            max = 0;
            for (int j = 1; j <= i / 2; ++j) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
            }
            products[i] = max;
        }

        return products[length];
    }

    public static int maxProductAfterCuttingByGreedy(int length) {
        if (length < 2) {
            return 0;
        } else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }

        int timesOf3 = length / 3;
        if (length - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;

        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
    }



    public static void main(String[] args) {

        System.out.println(cuttingRope(10));
        System.out.println(maxProductAfterCuttingByGreedy(10));

    }


}
