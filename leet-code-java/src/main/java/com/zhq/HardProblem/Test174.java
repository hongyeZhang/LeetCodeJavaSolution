package com.zhq.HardProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/27 22:39
 */
public class Test174 {

    /**
     * dp[i][j] 代表从 grid[i][j] 到达右下角所需要的最少的血量
     * todo 感觉有问题，暂且搁置！！！
     *
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = dungeon[i][j] > 0 ? 1 : -dungeon[i][j] + 1;
                    continue;
                }
                if (i == m - 1) {
                    dp[i][j] = dp[i][j + 1] - dungeon[i][j];
                    continue;
                }
                if (j == n - 1) {
                    dp[i][j] = dp[i + 1][j] - dungeon[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
            }
        }
        return dp[0][0];
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP(matrix));

    }

}
