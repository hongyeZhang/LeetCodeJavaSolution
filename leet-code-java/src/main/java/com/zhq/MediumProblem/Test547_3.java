package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/25 09:27
 */
public class Test547_3 {

    /**
     * 深度优先搜索求解联通域的个数问题
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) {
            return 0;
        }
        int cityNum = isConnected.length;
        boolean[] visited = new boolean[cityNum];
        int circle = 0;
        for (int i = 0; i < cityNum; ++i) {
            if (!visited[i]) {
                dfs(isConnected, visited, cityNum, i);
                circle++;
            }
        }
        return circle;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int cityNum, int i) {
        for (int j = 0; j < cityNum; ++j) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                dfs(isConnected, visited, cityNum, j);
            }
        }
    }


    @Test
    public void test() {
        int[][] board = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int circleNum = findCircleNum(board);
        System.out.println(circleNum);
    }

}
