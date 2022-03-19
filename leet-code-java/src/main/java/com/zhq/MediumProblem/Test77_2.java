package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/14 19:30
 */
public class Test77_2 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> retList = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(retList, track, 1, n, k);
        return retList;
    }

    /**
     * 组合问题与求子集问题类似，只不过是求指定个数的子集
     * @param retList
     * @param track
     * @param start
     * @param n
     * @param k
     */
    public void backTrack(List<List<Integer>> retList, LinkedList<Integer> track, int start, int n, int k) {
        if (track.size() == k) {
            retList.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; ++i) {
            track.addLast(i);
            backTrack(retList, track, i + 1, n, k);
            track.removeLast();
        }
    }

    @Test
    public void test() {
        List<List<Integer>> retList = combine(4, 2);
        for (List<Integer> integers : retList) {
            System.out.println(integers);
        }
    }


}
