package com.zhq.HardProblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/27 22:39
 */
public class Test174 {

    /**
     * dp[i][j] 代表从 grid[i][j] 到达右下角所需要的最少的血量
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] memo = new int[m][n];
        for (int[] rows : memo) {
            Arrays.fill(rows, -1);
        }
        return dp(dungeon, memo, 0, 0);
    }

    public int dp(int[][] grid, int[][] memo, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i == m - 1 && j == n - 1) {
            return grid[i][j] > 0 ? 1 : -grid[i][j] + 1;
        }
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Math.min(dp(grid, memo, i + 1, j), dp(grid, memo, i, j + 1)) - grid[i][j];
        res = res <= 0 ? 1 : res;
        memo[i][j] = res;
        return res;
    }


    @Test
    public void test() {
//        int[][] matrix = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int[][] matrix = new int[][]{{0, 0, 0}, {1, 1, -1}};
        Assert.assertEquals(1, calculateMinimumHP(matrix));
    }

}
