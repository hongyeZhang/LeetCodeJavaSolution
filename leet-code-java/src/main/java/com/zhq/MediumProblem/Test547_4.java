package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/25 10:17
 */
public class Test547_4 {


    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) {
            return 0;
        }
        int cityNum = isConnected.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[cityNum];
        int circle = 0;
        for (int i = 0; i < cityNum; ++i) {
            if (!visited[i]) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < cityNum; ++k) {
                        if (!visited[k] && isConnected[j][k] == 1) {
                            queue.add(k);
                        }
                    }
                }
                circle++;
            }
        }
        return circle;
    }


    @Test
    public void test() {
        int[][] board = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int circleNum = findCircleNum(board);
        System.out.println(circleNum);
    }
}
