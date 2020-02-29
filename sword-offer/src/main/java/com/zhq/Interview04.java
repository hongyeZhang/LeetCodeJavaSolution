package com.zhq;

import java.util.jar.JarEntry;

/**
 * @author : ZHQ
 * @date : 2020/2/29
 */
public class Interview04 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;

        // 从右上角开始选择
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            int current = matrix[i][j];
            if (current == target) {
                return true;
            } else if (current > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }




    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};

        System.out.println(findNumberIn2DArray(matrix, 5));
        System.out.println(findNumberIn2DArray(matrix, 20));




    }
}
