package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/18
 */
public class Test279 {

    int minNum = Integer.MAX_VALUE;

    /** 超出时间限制
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int maxInteger = (int) Math.floor(Math.pow(n, 0.5));
        int[] squareNum = new int[maxInteger];
        for (int i = 1; i <= maxInteger; ++i) {
            squareNum[i - 1] = (int) Math.pow(i, 2);
        }

        List<List<Integer>> retList = new ArrayList<>();
        for (int i = 0; i < squareNum.length; ++i) {
            allPath(squareNum, squareNum[i], n, retList, new ArrayList<>(Arrays.asList(squareNum[i])));
        }
        return minNum;
    }

    public void allPath(int[] squareNum, int currentSum, int expectedSum, List<List<Integer>> retList, List<Integer> currentPath) {
        if (currentSum == expectedSum) {
            minNum = Math.min(minNum, currentPath.size());
            retList.add(currentPath);
        } else if (currentSum > expectedSum) {
            return;
        } else{
            for (int i = 0; i < squareNum.length; ++i) {
                List<Integer> tmpList = new ArrayList<>(currentPath);
                tmpList.add(squareNum[i]);
                allPath(squareNum, currentSum + squareNum[i], expectedSum, retList, tmpList);
            }
        }
    }

    @Test
    public void test() {
//        System.out.println(numSquares(13));
        System.out.println(numSquares(40));
    }





}
