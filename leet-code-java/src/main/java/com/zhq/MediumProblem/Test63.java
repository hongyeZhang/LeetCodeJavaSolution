package com.zhq.MediumProblem;

import com.zhq.util.IntUtil;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class Test63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        // 初始化第一列
        for (int i = 0; i < row; ++i) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = Integer.MIN_VALUE;
                while (i < row) {
                    dp[i++][0] = Integer.MIN_VALUE;
                }
                break;
            }
        }

        // 初始化第一行
        for (int j = 0; j < col; ++j) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = Integer.MIN_VALUE;
                while (j < col) {
                    dp[0][j++] = Integer.MIN_VALUE;
                }
                break;
            }
        }

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = Integer.MIN_VALUE;
                } else {
                    if (dp[i][j - 1] == Integer.MIN_VALUE && dp[i - 1][j] != Integer.MIN_VALUE) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (dp[i][j - 1] != Integer.MIN_VALUE && dp[i - 1][j] == Integer.MIN_VALUE) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (dp[i][j - 1] == Integer.MIN_VALUE && dp[i - 1][j] == Integer.MIN_VALUE) {
                        dp[i][j] = Integer.MIN_VALUE;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }

        int ret = dp[row - 1][col - 1];
        if (Integer.MIN_VALUE == ret) {
            ret = 0;
        }
        return ret;
    }

    public static void main(String[] args) {

        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));






    }


}
