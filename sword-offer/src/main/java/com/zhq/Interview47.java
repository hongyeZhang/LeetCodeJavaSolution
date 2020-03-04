package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/3
 */
public class Interview47 {

    public static int maxValue(int[][] grid) {
        if (null == grid) {
            return 0;
        }
        if (grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; ++i) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; ++i) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }

        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(maxValue(grid));
    }
}
