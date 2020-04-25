package com.zhq;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/3/5
 */
public class Interview57_2 {

    public static int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return null;
        }
        List<List<Integer>> retList = findContinuousSequenceCore(target);
        int[][] ret = new int[retList.size()][];

        for (int index = 0; index < retList.size(); ++index) {
            List<Integer> list = retList.get(index);
            int[] tmpArr = new int[list.size()];
            for (int i = 0; i < list.size(); ++i) {
                tmpArr[i] = list.get(i);
            }
            ret[index] = tmpArr;
        }

        return ret;
    }

    public static List<List<Integer>> findContinuousSequenceCore(int target) {
        List<List<Integer>> retList = new ArrayList<>();

        int small = 1;
        int big = 2;
        int mid = (target + 1) / 2;
        int currentSum = small + big;

        while (small < mid) {
            if (currentSum == target) {
                List<Integer> tmpList = new ArrayList<>();
                for (int i = small; i <= big; ++i) {
                    tmpList.add(i);
                }
                retList.add(tmpList);
            }
            while (small < mid && currentSum > target) {
                currentSum -= small;
                small++;
                if (currentSum == target) {
                    List<Integer> tmpList = new ArrayList<>();
                    for (int i = small; i <= big; ++i) {
                        tmpList.add(i);
                    }
                    retList.add(tmpList);
                }
            }
            big++;
            currentSum += big;
        }

        return retList;
    }

    public static void main(String[] args) {

        int[][] ret = findContinuousSequence(15);
        int row = ret.length;
        for (int i = 0; i < row; ++i) {
            int[] tmpArr = ret[i];
            for (int j = 0; j < tmpArr.length; ++j) {
                System.out.print(tmpArr[j] + "\t");
            }
            System.out.println();
        }



    }


}
