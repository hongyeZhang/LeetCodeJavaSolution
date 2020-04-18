package com.zhq.SimpleProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : ZHQ
 * @date : 2020/4/15
 */
public class Test252 {

    public boolean canAttendMeetings(int[][] intervals) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };

        Arrays.sort(intervals, comparator);
        int length = intervals.length;
        for (int i = 0; i < length - 1; ++i) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[][] intervals = new int[][] {{5, 10}, {15, 20}, {0, 30}};

        canAttendMeetings(intervals);





    }









}
