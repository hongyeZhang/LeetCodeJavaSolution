package com.zhq.util;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public final class IntUtil {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printIntMatrix(matrix);


    }


    public static void printIntArray(int[] inputArr) {
        for (int i : inputArr) {
            System.out.print(i + "\t");
        }
    }

    public static void printIntMatrix(int[][] inputMatrix) {
        int row = inputMatrix.length;
        int col = inputMatrix[0].length;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                System.out.print(inputMatrix[i][j] + "\t");
            }
            System.out.println();
        }

    }

}
