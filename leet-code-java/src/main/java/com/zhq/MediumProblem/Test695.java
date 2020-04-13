package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/4/13
 */
public class Test695 {

    /**
     * 深度优先遍历（递归实现）
     *
     *
     *
     * 时间复杂度：O(R * C)O(R∗C)。其中 RR 是给定网格中的行数，CC 是列数。我们访问每个网格最多一次。
     *
     * 空间复杂度：O(R * C)O(R∗C)，递归的深度最大可能是整个网格的大小，因此最大可能使用 O(R * C)O(R∗C) 的栈空间。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/max-area-of-island/solution/dao-yu-de-zui-da-mian-ji-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowMax = grid.length;
        int colMax = grid[0].length;
        int max = 0;
        for (int i = 0; i < rowMax; ++i) {
            for (int j = 0; j < colMax; ++j) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }

        return max;
    }

    public int dfs(int i, int j, int[][] grid) {
        int rowMax = grid.length;
        int colMax = grid[0].length;
        if (i < 0 || i >= rowMax || j < 0 || j >= colMax || grid[i][j] == 0) {
            return 0;
        }
        int num = 1;
        grid[i][j] = 0;
        num += dfs(i - 1, j, grid);
        num += dfs(i + 1, j, grid);
        num += dfs(i, j - 1, grid);
        num += dfs(i, j + 1, grid);
        return num;
    }


    @Test
    public void test() {
        int[][] grid = new int[][] {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}};

        int max = maxAreaOfIsland(grid);
        System.out.println(max);
    }



    /**
     * 深度优先遍历，（栈实现）
     * 放入栈的都是上一个访问过的土地
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland2(int[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowMax = grid.length;
        int colMax = grid[0].length;
        int maxArea = 0;

        Stack<Integer> iStack = new Stack<>();
        Stack<Integer> jStack = new Stack<>();

        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        for (int i = 0; i < rowMax; ++i) {
            for (int j = 0; j < colMax; ++j) {
                if (grid[i][j] == 1) {
                    iStack.push(i);
                    jStack.push(j);
                    grid[i][j] = 0;
                    int currentArea = 1;
                    while (!iStack.isEmpty() && !jStack.isEmpty()) {
                        int x = iStack.pop();
                        int y = jStack.pop();
                        for (int index = 0; index < dx.length; ++index) {
                            int nextX = x + dx[index];
                            int nextY = y + dy[index];
                            if (nextX >= 0 && nextX < rowMax && nextY >= 0 && nextY < colMax
                                            && grid[nextX][nextY] == 1) {
                                iStack.push(nextX);
                                jStack.push(nextY);
                                grid[nextX][nextY] = 0;
                                currentArea++;
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }

    @Test
    public void test2() {
        int[][] grid = new int[][] {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1},
                        {1, 1, 0, 1, 1}};

        System.out.println(maxAreaOfIsland2(grid));
    }











}
