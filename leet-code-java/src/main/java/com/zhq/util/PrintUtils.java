package com.zhq.util;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/4 10:07
 */
public final class PrintUtils {

    private PrintUtils() {
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) {
            return;
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
    }

}
