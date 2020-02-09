package com.zhq.MediumProblem;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class Test56_2 {

    private static class Interval {
        int start;
        int end;
        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        int[] toArray() {
            return new int[]{this.start, this.end};
        }
    }

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }
    }


    /**
     * 参考官方题解：
     * https://leetcode-cn.com/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode/
     * 
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new LinkedList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval));
        }
        intervalList.sort(new IntervalComparator());

        // 合并区间
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervalList) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        int[][] res = new int[merged.size()][2];
        int i = 0;
        for (Interval interval : merged) {
            res[i] = interval.toArray();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; ++i) {
            System.out.print(merge[i][0] + "\t" + merge[i][1]);
            System.out.println();
        }

    }






}
