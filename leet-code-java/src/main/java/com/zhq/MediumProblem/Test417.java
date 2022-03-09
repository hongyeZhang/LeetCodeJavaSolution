package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/27 10:19
 */
public class Test417 {

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};



    /**
     * 深度优先搜索
     * 一个点如果能够同时到达太平洋和大西洋，那么路径的最终端点一定四条边中的其中一条。那么从四条边开始，逆流往上搜索即可。
     *
     *
     * @param heights
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights[0].length == 0) {
            return Collections.emptyList();
        }
        int rowMax = heights.length;
        int colMax = heights[0].length;
        int[][] reachP = new int[rowMax][colMax];
        int[][] reachA = new int[rowMax][colMax];
        for (int i = 0; i < rowMax; ++i) {
            reachP[i][0] = 1;
            dfs(heights, reachP, i, 0);
            reachA[i][colMax - 1] = 1;
            dfs(heights, reachA, i, colMax - 1);
        }
        for (int i = 0; i < colMax; ++i) {
            reachP[0][i] = 1;
            dfs(heights,reachP , 0, i);
            reachA[rowMax - 1][i] = 1;
            dfs(heights, reachA, rowMax - 1, i);
        }


        List<List<Integer>> retList = new ArrayList<>();
        for (int i = 0; i < rowMax; ++i) {
            for (int j = 0; j < colMax; ++j) {
                if (reachA[i][j] == 1 && reachP[i][j] == 1) {
                    retList.add(Arrays.asList(i, j));
                }
            }
        }
        return retList;
    }

    public void dfs(int[][] heights, int[][] reach, int r, int c) {
        int rowMax = heights.length;
        int colMax = heights[0].length;
        for (int i = 0; i < dx.length; ++i) {
            int nextR = r + dx[i];
            int nextC = c + dy[i];
            if (nextR < 0 || nextR >= rowMax || nextC < 0 || nextC >= colMax || reach[nextR][nextC] == 1) {
                continue;
            }
            if (heights[nextR][nextC] >= heights[r][c]) {
                reach[nextR][nextC] = 1;
                dfs(heights, reach, nextR, nextC);
            }
        }
    }


    @Test
    public void test() {
        int[][] heights = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};

        List<List<Integer>> lists = pacificAtlantic(heights);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }


    }




}
