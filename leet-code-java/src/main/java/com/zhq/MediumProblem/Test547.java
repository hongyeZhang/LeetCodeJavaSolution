package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test547 {

    static class UnionFind {
        int count;
        int[] id;
        int[] w;

        public UnionFind(int count) {
            this.count = count;
            this.id = new int[count];
            this.w = new int[count];
            for (int i = 0; i < count; ++i) {
                id[i] = i;
                w[i] = 1;
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
                w[pRoot] += w[pRoot];
            }
            count--;
        }
    }

    /**
     * 朋友圈 ： 连通区域的个数
     *
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        if (null == M || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int Num = M.length;
        List<int[]> edges = new LinkedList<>();
        for (int i = 0; i < Num; ++i) {
            for (int j = i + 1; j < Num; ++j) {
                if (M[i][j] == 1) {
                    edges.add(new int[] {i, j});
                }
            }
        }
        int n = edges.size();
        int[][] inputGrid = edges.toArray(new int[n][2]);

        UnionFind unionFind = new UnionFind(Num);
        for (int[] ints : inputGrid) {
            unionFind.union(ints[0], ints[1]);
        }

        return unionFind.count();
    }

    @Test
    public void test() {
        int[][] grid = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] grid2 = new int[][] {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(findCircleNum(grid2));


    }





}
