package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : ZHQ
 * @date : 2020/4/18
 */
public class Test542 {

    /**
     * 广度优先遍历
     *
     * 从 0 开始，逐步按层向外计算距离
     *
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int rowMax = matrix.length;
        int colMax = matrix[0].length;
        int[][] distanceMatrix = new int[rowMax][colMax];
        boolean[][] visitedMatrix = new boolean[rowMax][colMax];

        int[][] moveIndexArray = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] ints : distanceMatrix) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        // 初始化
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < rowMax; ++i) {
            for (int j = 0; j < colMax; ++j) {
                if (matrix[i][j] == 0) {
                    distanceMatrix[i][j] = 0;
                    deque.offer(new int[] {i, j});
                    visitedMatrix[i][j] = true;
                }
            }
        }

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            for (int[] moveIndex : moveIndexArray) {
                int nextI = current[0] + moveIndex[0];
                int nextJ = current[1] + moveIndex[1];
                if (nextI >= 0 && nextI < rowMax && nextJ >= 0 && nextJ < colMax && !visitedMatrix[nextI][nextJ]) {
                    distanceMatrix[nextI][nextJ] = distanceMatrix[current[0]][current[1]] + 1;
                    deque.offer(new int[] {nextI, nextJ});
                    visitedMatrix[nextI][nextJ] = true;
                }
            }
        }

        return distanceMatrix;
    }


    @Test
    public void test() {
        int[][] matrix = new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] retMatrix = updateMatrix(matrix);
        for (int[] ints : retMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

    }


}
