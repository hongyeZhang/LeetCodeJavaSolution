package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test695_2 {

    /**
     *
     * DFS
     * 通过栈实现
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
        int maxArea = 0;
        Deque<int[]> stack = new LinkedList<>();
        int[][] moveIndexArray = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < rowMax; ++i) {
            for (int j = 0; j < colMax; ++j) {
                stack.push(new int[] {i, j});
                int currentArea = 0;
                while (!stack.isEmpty()) {
                    int[] pop = stack.pop();
                    int currI = pop[0];
                    int currJ = pop[1];
                    if (currI < 0 || currI >= rowMax || currJ < 0 || currJ >= colMax
                                    || grid[currI][currJ] == 0) {
                        continue;
                    }
                    currentArea++;
                    grid[currI][currJ] = 0;
                    for (int[] moveIndex : moveIndexArray) {
                        stack.push(new int[] {currI + moveIndex[0], currJ + moveIndex[1]});
                    }
                }
                maxArea = Math.max(maxArea, currentArea);
            }
        }
        return maxArea;
    }

    @Test
    public void test() {
        int[][] grid = new int[][] {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}};

        int max = maxAreaOfIsland(grid);
        System.out.println(max);
    }

    /**
     * BFS
     * 通过队列实现
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
        Deque<int[]> queue = new LinkedList<>();
        int[][] moveIndexArray = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < rowMax; ++i) {
            for (int j = 0; j < colMax; ++j) {
                queue.offer(new int[] {i, j});
                int currentArea = 0;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int index = 0; index < size; ++index) {
                        int[] ints = queue.pollFirst();
                        int currI = ints[0];
                        int currJ = ints[1];
                        if (currI < 0 || currI >= rowMax || currJ < 0 || currJ >= colMax
                                        || grid[currI][currJ] == 0) {
                            continue;
                        }
                        currentArea++;
                        grid[currI][currJ] = 0;
                        for (int[] moveIndex : moveIndexArray) {
                            queue.offer(new int[] {currI + moveIndex[0], currJ + moveIndex[1]});
                        }
                    }
                }
                maxArea = Math.max(maxArea, currentArea);
            }
        }
        return maxArea;
    }

    @Test
    public void test2() {
        int[][] grid = new int[][] {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}};
        int[][] grid2 = new int[][] {{1, 1}};

        int max = maxAreaOfIsland2(grid2);
        System.out.println(max);
    }









}
