package com.zhq.ordinaryAlgorithm;

import java.util.Arrays;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-05-19 17:03
 **/
public class DynamicPlanning {

    /**
     * @Description: 输入给定的硬币面值，从{1,3,5}中选出组成该面值的最少的硬币个数
     * @Param: [targetNum] 给定的硬币面值，如 11元
     * @return: void
     * @Author: ZHQ
     * @Date: 2019/5/19
     **/
    public static void getMinNumCoin(int targetNum) {
        // 将组成某一个数值最少的硬币个数存放在一个数组里
        targetNum++;
        int[] minCoinNum = new int[targetNum];
        Arrays.fill(minCoinNum, 0);

        int[] basicValue = {1, 3, 5};

        for (int i = 1; i < targetNum; ++i) {
            minCoinNum[i] = minCoinNum[i - 1] + 1;
            for (int j = 0; j < basicValue.length; ++j) {
                if (basicValue[j] > i) {
                    continue;
                }
                minCoinNum[i] = minCoinNum[i - basicValue[j]] + 1;
            }
        }

        int minNum = minCoinNum[targetNum - 1];
        System.out.println("组成 " + (targetNum-1) + " 元的最少的硬币个数为：" + minNum);
    }

    public static void main(String[] args) {

        getMinNumCoin(11);

    }
}
