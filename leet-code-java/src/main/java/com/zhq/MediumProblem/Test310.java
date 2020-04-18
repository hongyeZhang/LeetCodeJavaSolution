package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/18
 */
public class Test310 {

    /**
     *
     * 拓扑排序的变种
     *
     * 取最后剩余的度数为 1 的节点
     *
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> retList = new ArrayList<>();
        // 为了满足 leetcode 上面的边界情况
        if (n == 1) {
            retList.add(0);
            return retList;
        }

        if (null == edges || edges.length == 0 || edges[0].length == 0 || n < 1) {
            return retList;
        }

        int[] degree = new int[n];
        List<List<Integer>> nodeMatrix = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            nodeMatrix.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            nodeMatrix.get(edge[0]).add(edge[1]);
            nodeMatrix.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; ++i) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            retList.clear();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Integer node = queue.pollFirst();
                retList.add(node);
                List<Integer> next = nodeMatrix.get(node);
                for (Integer integer : next) {
                    degree[integer]--;
                    if (degree[integer] == 1) {
                        queue.offer(integer);
                    }
                }
            }
        }

        return retList;
    }

    @Test
    public void test(){
        int[][] edges = new int[][] {{1, 0}, {1, 2}, {1, 3}};
        int n = 4;
        List<Integer> minHeightTrees = findMinHeightTrees(n, edges);
        System.out.println(minHeightTrees);
    }










}
