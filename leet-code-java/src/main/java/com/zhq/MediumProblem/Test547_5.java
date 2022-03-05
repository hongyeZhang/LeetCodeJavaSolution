package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/26 15:41
 */
public class Test547_5 {

    /**
     * 并查集标准模板
     *
     */
    static class UnionFind {
        // 记录父节点
        private Map<Integer,Integer> father;
        // 记录集合的数量
        private int numOfSets = 0;

        public UnionFind() {
            father = new HashMap<>();
            numOfSets = 0;
        }

        public void add(int x) {
            if (!father.containsKey(x)) {
                father.put(x, null);
                numOfSets++;
            }
        }

        public void merge(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                father.put(rootX, rootY);
                numOfSets--;
            }
        }

        public int find(int x) {
            int root = x;
            while (father.get(root) != null) {
                root = father.get(root);
            }
            // 路径压缩
            while (x != root) {
                int originFather = father.get(x);
                father.put(x, root);
                x = originFather;
            }
            return root;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int getNumOfSets() {
            return numOfSets;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        UnionFind unionFind = new UnionFind();
        for (int i = 0; i < isConnected.length; ++i) {
            unionFind.add(i);
        }

        for (int i = 0; i < isConnected.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (isConnected[i][j] == 1 && !unionFind.isConnected(i, j)) {
                    unionFind.merge(i, j);
                }
            }
        }
        return unionFind.getNumOfSets();
    }

    @Test
    public void test() {
        int[][] board = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int circleNum = findCircleNum(board);
        System.out.println(circleNum);
    }

}
