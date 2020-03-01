package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class Interview13 {

    public static int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }
        boolean visitedFlag[][] = new boolean[m][n];
        int count = movingCountCore(0, m, 0, n, k, visitedFlag);

        return count;
    }

    public static int movingCountCore(int row, int rowMax, int col, int colMax, int threshold
                    ,boolean[][] visitedFlag) {
        int count = 0;
        if (checkCoordinate(row, rowMax, col, colMax, threshold, visitedFlag)) {
            visitedFlag[row][col] = true;
            count = 1 + movingCountCore(row + 1, rowMax, col, colMax, threshold, visitedFlag)
                            + movingCountCore(row - 1, rowMax, col, colMax, threshold, visitedFlag)
                            + movingCountCore(row, rowMax, col + 1, colMax, threshold, visitedFlag)
                            + movingCountCore(row, rowMax, col - 1, colMax, threshold, visitedFlag);
        }
        return count;
    }

    public static boolean checkCoordinate(int row, int rowMax, int col, int colMax, int threshold
                    , boolean[][] visitedFlag) {
        if (row >= 0 && row < rowMax && col >= 0 && col < colMax && getSum(row) + getSum(col)
                        <= threshold && !visitedFlag[row][col]) {
            return true;
        }
        return false;
    }

    public static int getSum(int coordinate) {
        int sum = 0;
        while (coordinate > 0) {
            sum += coordinate % 10;
            coordinate /= 10;
        }
        return sum;
    }



    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
        System.out.println(movingCount(3, 1, 0));


    }

}
