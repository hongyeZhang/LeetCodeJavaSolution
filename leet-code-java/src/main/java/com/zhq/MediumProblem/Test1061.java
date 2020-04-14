package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test1061 {

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
                w[qRoot] += w[pRoot];
            } else {
                id[qRoot] = pRoot;
                w[pRoot] += w[qRoot];
            }
            count--;
        }


        public List<Set<Integer>> allUnionSet() {
            List<Set<Integer>> retList = new ArrayList<>();

            for (int i = 0; i < id.length; ++i) {
                if (i != id[i] && id[i] != -1) {
                    int p = i;
                    HashSet<Integer> tmpSet = new HashSet<>();
                    while (p != id[p]) {
                        tmpSet.add(p);
                        int tmp = id[p];
                        id[p] = -1;
                        p = tmp;

                    }
                    tmpSet.add(p);
                    retList.add(tmpSet);
                }
            }
            return retList;
        }
    }




    public String smallestEquivalentString(String A, String B, String S) {
        if (null == A || null == B || null == S) {
            return "";
        }

        int len = A.length();
        int[][] grid = new int[26][26];
        for (int i = 0; i < len; ++i) {
            int rowIndex = A.charAt(i) - 'a';
            int colIndex = B.charAt(i) - 'a';
            grid[rowIndex][colIndex] = 1;
            grid[colIndex][rowIndex] = 1;
        }

        List<int[]> edges = new LinkedList<>();
        for (int i = 0; i < 26; ++i) {
            for (int j = i + 1; j < 26; ++j) {
                if (grid[i][j] == 1) {
                    edges.add(new int[] {i, j});
                }
            }
        }

        UnionFind unionFind = new UnionFind(26);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        System.out.println(unionFind.count());

        List<Set<Integer>> sets = unionFind.allUnionSet();



        return "";

    }


    @Test
    public void test() {
        String A = "parker";
        String B = "morris";


        smallestEquivalentString(A, B, "");


    }






}
