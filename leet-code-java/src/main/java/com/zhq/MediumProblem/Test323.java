package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test323 {

    static class UnionFind {
        /**
         * 父节点
         */
        int[] id;

        /**
         * 权重（大小）
         */
        int[] w;

        /**
         * 联通分量的个数
         */
        int count;

        public UnionFind(int n) {
            this.count = n;
            id = new int[n];
            w = new int[n];
            for (int i = 0; i < n; ++i) {
                w[i] = 1;
                id[i] = i;
            }
        }

        public int count() {
            return count;
        }

        public int findRoot(int p) {
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            if (pRoot == qRoot) {
                return;
            }
            if (w[pRoot] < w[qRoot]) {
                id[pRoot] = qRoot;
                w[qRoot] += w[qRoot];
            } else {
                id[qRoot] = pRoot;
                w[qRoot] += w[pRoot];
            }
            count--;
        }
    }

    /**
     * 无向图的连通分量，模板问题
     *
     * @param n
     * @param edges
     * @return
     */
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.count();
    }

    @Test
    public void test() {
        int n = 5;
        int[][] edges = new int[][] {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(n, edges));

    }





}
