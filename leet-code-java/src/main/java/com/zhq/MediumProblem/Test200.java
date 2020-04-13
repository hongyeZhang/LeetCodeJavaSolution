package com.zhq.MediumProblem;

/**
 * @author : ZHQ
 * @date : 2020/4/13
 */
public class Test200 {

    public void dfs(char[][] grid, int i, int j) {
        int rowMax = grid.length;
        int colMax = grid[0].length;
        if (i < 0 || i >= rowMax || j < 0 || j >= colMax || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }


    /** AC
     * 深度优先遍历，将遍历到的岛屿修改状态
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowMax = grid.length;
        int colMax = grid[0].length;
        int islandNum = 0;

        for (int i = 0; i < rowMax; ++i) {
            for (int j = 0; j < colMax; ++j) {
                if (grid[i][j] == '1') {
                    islandNum++;
                    dfs(grid, i, j);
                }
            }
        }

        return islandNum;
    }


}
