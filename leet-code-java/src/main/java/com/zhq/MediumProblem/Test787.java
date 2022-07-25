package com.zhq.MediumProblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHQ
 * @date 2022/7/23
 */
public class Test787 {

    HashMap<Integer, List<int[]>> indegree;
    int src;
    int dst;
    int[][] memo;

    public static final int STUB = -888;
    public static final int NO_SOLUTION = -1;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        indegree = new HashMap<>();
        // 经过K次中转，即走K+1次。
        k = k + 1;
        this.src = src;
        this.dst = dst;
        memo = new int[n][k + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, STUB);
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            indegree.putIfAbsent(to, new LinkedList<>());
            indegree.get(to).add(new int[]{from, cost});
        }
        return dp(dst, k);
    }

    /**
     * 从 src 出发，到达节点 s 一共需要 k 步
     * @param s
     * @param k
     * @return
     */
    public int dp(int s, int k) {
        if (s == this.src) {
            return 0;
        }
        if (k == 0) {
            // 表示没有解
            return NO_SOLUTION;
        }
        if (memo[s][k] != STUB) {
            return memo[s][k];
        }

        int res = Integer.MAX_VALUE;
        List<int[]> nodes = indegree.get(s);
        for (int[] node : nodes) {
            int from = node[0];
            int cost = node[1];
            int subProblem = dp(from, k - 1);
            if (subProblem != NO_SOLUTION) {
                res = Math.min(res, subProblem + cost);
            }
        }
        memo[s][k] = res;
        return res;
    }

    @Test
    public void test() {
        int n = 3;
        int[][] edges = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        Assert.assertEquals(200, findCheapestPrice(n, edges, src, dst, k));
        Assert.assertEquals(500, findCheapestPrice(n, edges, 0, 2, 0));

    }

}
