package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/15
 */
public class Test54_2 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> retList = new ArrayList<>();

        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return retList;
        }

        int rowMax = matrix.length;
        int colMax = matrix[0].length;

        boolean[][] visitedMatrix = new boolean[rowMax][colMax];

        int currentRow = 0, currentCol = 0;
        int directionIndex = 0;
        int[][] directionArray = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < rowMax * colMax; ++i) {
            retList.add(matrix[currentRow][currentCol]);
            visitedMatrix[currentRow][currentCol] = true;
            int nextRow = currentRow + directionArray[directionIndex][0];
            int nextCol = currentCol + directionArray[directionIndex][1];
            if (nextRow >= 0 && nextRow < rowMax && nextCol >= 0 && nextCol < colMax
                            && !visitedMatrix[nextRow][nextCol]) {
                currentRow = nextRow;
                currentCol = nextCol;
            } else {
                directionIndex = (directionIndex + 1) % 4;
                currentRow += directionArray[directionIndex][0];
                currentCol += directionArray[directionIndex][1];
            }
        }

        return retList;
    }

    @Test
    public void test() {
        int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        List<Integer> list = spiralOrder(matrix);

        System.out.println(list);

    }



}
