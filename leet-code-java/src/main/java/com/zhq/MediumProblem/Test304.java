package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/4 09:46
 */
public class Test304 {


    /**
     * 提前计算(0,0) 到 (i,j) 之间的累计和，直接相减就行
     */
    @Test
    public void test() {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
//        PrintUtils.printMatrix(matrix);

        NumMatrix numMatrix = new NumMatrix(matrix);

//        int ret = numMatrix.sumRegion(2, 1, 4, 3);
//        int ret = numMatrix.sumRegion(1, 1, 2, 2);
        int ret = numMatrix.sumRegion(1, 2, 2, 4);
        System.out.println(ret);
    }



    class NumMatrix {

        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix[0].length == 0) {
                return;
            }
            int m = matrix.length, n = matrix[0].length;
            preSum = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i == 0 && j == 0) {
                        preSum[0][0] = matrix[0][0];
                        continue;
                    }
                    if (i == 0) {
                        preSum[0][j] = preSum[0][j - 1] + matrix[i][j];
                        continue;
                    }
                    if (j == 0) {
                        preSum[i][0] = preSum[i - 1][0] + matrix[i][j];
                        continue;
                    }
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i][j] - preSum[i - 1][j - 1];
                }
            }
        }


        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) {
                return preSum[row2][col2];
            }
            if (col1 == 0) {
                return preSum[row2][col2] - preSum[row1 - 1][col2];
            }
            if (row1 == 0) {
                return preSum[row2][col2] - preSum[row2][col1 - 1];
            }
            return preSum[row2][col2] - preSum[row2][col1 - 1] - preSum[row1 - 1][col2] + preSum[row1 - 1][col1 - 1];
        }

    }

}
