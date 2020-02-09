package com.zhq.MediumProblem;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/2/8
 */
public class Test56 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; ++i) {
            System.out.print(merge[i][0] + "\t" + merge[i][1]);
            System.out.println();
        }

    }

    /** Pair 这个数据结构不让用！！！
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[0][0];
        }

        List<Pair<Integer, Integer>> intervalList = new ArrayList<>();
        intervalList.add(new Pair<>(intervals[0][0], intervals[0][1]));
        for (int i = 1; i < len; ++i) {
            Pair<Integer, Integer> tmpPair = new Pair<>(intervals[i][0], intervals[i][1]);
            boolean addFlag = true;
            for (int j = 0; j < intervalList.size(); ++j) {
                if (isOverlapping(intervalList.get(j), tmpPair)) {
                    intervalList.set(j, unionPair(intervalList.get(j), tmpPair));
                    addFlag = false;
                }
            }
            if (addFlag) {
                intervalList.add(tmpPair);
            }
        }
        // 格式转化
        int[][] res = new int[intervalList.size()][2];
        for (int i = 0; i < intervalList.size(); ++i) {
            res[i][0] = intervalList.get(i).getKey();
            res[i][1] = intervalList.get(i).getValue();
        }

        return res;
    }

    public static boolean isOverlapping(Pair<Integer, Integer> first, Pair<Integer, Integer> second) {
        int firstStart = first.getKey();
        int firstEnd = first.getValue();
        int secondStart = second.getKey();
        int secondEnd = second.getValue();
        if ((secondStart >= firstStart && secondStart <= firstEnd) || (secondEnd >= firstStart && secondEnd <= firstEnd)) {
            return true;
        }
        return false;
    }

    public static Pair<Integer, Integer> unionPair(Pair<Integer, Integer> first, Pair<Integer, Integer> second) {
        Integer key = Math.min(first.getKey(), second.getKey());
        Integer value = Math.max(first.getValue(), second.getValue());
        return new Pair<>(key, value);
    }






}
