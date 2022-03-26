package com.zhq.MediumProblem;

import org.junit.Test;


/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/20 10:57
 */
public class Test931 {

    /**
     * dp[i][j] 代表以 matrix[i][j] 为结尾的最小路径的和
     *
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i - 1][j + 1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }


    @Test
    public void test() {
        int[][] matrix = new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(minFallingPathSum(matrix));

    }

}
