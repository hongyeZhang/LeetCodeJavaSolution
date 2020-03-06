package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/5
 */
public class Interview60 {
    public static final int NUM = 6;

    public static double[] twoSum(int n) {
        if (n < 1) {
            return null;
        }

        int maxSum = n * NUM;
        int[] probabilityArr = new int[maxSum - n + 1];
        probability(n, probabilityArr);
        double total = Math.pow(NUM, n);

        double[] ret = new double[probabilityArr.length];
        for (int i = 0; i < probabilityArr.length; ++i) {
            ret[i] = probabilityArr[i] / total;
        }

        return ret;
    }

    public static void probability(int number, int[] timeArr) {
        for (int i = 1; i <= NUM; ++i) {
            probabilityCore(number, number, i, timeArr);
        }
    }

    public static void probabilityCore(int original, int current, int currentSum, int[] timeArr) {
        if (current == 1) {
            timeArr[currentSum - original]++;
        } else {
            for (int i = 1; i <= NUM; ++i) {
                probabilityCore(original, current - 1, currentSum + i, timeArr);
            }
        }

    }


    public static void main(String[] args) {
        double[] doubles = twoSum(2);
        for (double aDouble : doubles) {
            System.out.print(aDouble + "\t");
        }


    }

}
