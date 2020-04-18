package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : ZHQ
 * @date : 2020/4/18
 */
public class Test490_2 {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (null == maze || maze.length == 0 || maze[0].length == 0 || null == start
                        || null == destination) {
            return false;
        }

        int[][] movedIndexArray = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rowMax = maze.length;
        int colMax = maze[0].length;

        Deque<int[]> queue = new LinkedList<>();
        queue.offer(start);
        boolean hasPath = false;

        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            if (current[0] == destination[0] && current[1] == destination[1]) {
                return true;
            } else {
                for (int[] movedIndex : movedIndexArray) {
                    int nextI = current[0] + movedIndex[0];
                    int nextJ = current[1] + movedIndex[1];
                    if (nextI >= 0 && nextI < rowMax && nextJ >= 0 && nextJ < colMax
                                    && maze[nextI][nextJ] == 0) {
                        queue.offer(new int[] {nextI, nextJ});
                    }
                }
            }
        }

        return hasPath;
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
