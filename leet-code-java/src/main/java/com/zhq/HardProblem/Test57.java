package com.zhq.HardProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class Test57 {

    private static class Interval {
        int start;
        int end;
        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
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

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval));
        }

        Interval toBeAdd = new Interval(newInterval);


        // 先将要插入的元素更新上。。。   有问题
        // TODO: 2020/2/9 这个思路存在问题
        ListIterator<Interval> listIterator = intervalList.listIterator();
        while (listIterator.hasNext()) {
            Interval next = listIterator.next();
            if (isOverLap(next, toBeAdd)) {
                int start = Math.min(next.start, toBeAdd.start);
                int end = Math.max(next.end, toBeAdd.end);
                listIterator.set(new Interval(start, end));
                break;
            }
        }

        return null;

    }

    public static boolean isOverLap(Interval first, Interval second) {
        return second.end >= first.start && second.start <= first.end;
    }




    public static void main(String[] args) {



    }


}
