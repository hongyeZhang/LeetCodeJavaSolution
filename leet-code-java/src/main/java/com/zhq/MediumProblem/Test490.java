package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : ZHQ
 * @date : 2020/4/18
 */
public class Test490 {


    /**
     * 广度优先遍历
     * 注意的一点： 在碰到墙壁之后才允许改变方向
     *
     *
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (null == maze || maze.length == 0 || maze[0].length == 0 || null == start
                        || null == destination) {
            return false;
        }

        int rowMax = maze.length;
        int colMax = maze[0].length;
        boolean[][] visitedMatrix = new boolean[rowMax][colMax];
        int[][] moveIndexArray = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Deque<int[]> deque = new LinkedList<>();
        deque.offer(start);
        visitedMatrix[start[0]][start[1]] = true;
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            if (current[0] == destination[0] && current[1] == destination[1]) {
                return true;
            }
            for (int[] ints : moveIndexArray) {
                int iDir = ints[0];
                int jDir = ints[1];
                int nextI = current[0] + iDir;
                int nextJ = current[1] + jDir;
                while (nextI >= 0 && nextI < rowMax && nextJ >= 0 && nextJ < colMax && maze[nextI][nextJ] == 0) {
                    nextI += iDir;
                    nextJ += jDir;
                }
                // 如果这个转折点没有走过，则加入遍历队列
                if (!visitedMatrix[nextI - iDir][nextJ - jDir]) {
                    deque.offer(new int[] {nextI - iDir, nextJ - jDir});
                    visitedMatrix[nextI - iDir][nextJ - jDir] = true;
                }
            }
        }

        return false;
    }


    @Test
    public void test() {
//        int[][] maze = new int[][] {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
//        int[] start = new int[] {0, 4};
//        int[] destination = new int[] {4, 4};


        int[][] maze = new int[][] {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = new int[] {0, 4};
        int[] destination = new int[] {3, 2};


        System.out.println(hasPath(maze, start, destination));
    }






}
