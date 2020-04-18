package com.zhq;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/16
 */
public class Interview12_2 {

    public boolean exist(char[][] board, String word) {
        if (null == board || board.length == 0 || board[0].length == 0 || word.length() == 0) {
            return false;
        }
        int rowMax = board.length;
        int colMax = board[0].length;
        boolean[][] visitedFlag = new boolean[rowMax][colMax];

        for (int i = 0; i < rowMax; ++i) {
            for (int j = 0; j < colMax; ++j) {
                if (hasPathCore(board, i, rowMax, j, colMax, 0, word, visitedFlag)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean hasPathCore(char[][] board, int row, int rowMax, int col, int colMax, int pathLen,
                    String word, boolean[][] visitedFlag) {
        // 递归终止条件
        if (pathLen == word.length()) {
            return true;
        }

        boolean hasPath = false;
        if (row >= 0 && row < rowMax && col >= 0 && col < colMax && board[row][col] == word.charAt(pathLen) && !visitedFlag[row][col]) {
            pathLen++;
            visitedFlag[row][col] = true;
            hasPath = hasPathCore(board, row + 1, rowMax, col, colMax, pathLen, word, visitedFlag)
                            || hasPathCore(board, row - 1, rowMax, col, colMax, pathLen, word, visitedFlag)
                            || hasPathCore(board, row, rowMax, col + 1, colMax, pathLen, word, visitedFlag)
                            || hasPathCore(board, row, rowMax, col - 1, colMax, pathLen, word, visitedFlag);
            if (!hasPath) {
                pathLen--;
                visitedFlag[row][col] = false;
            }
        }

        return hasPath;
    }



    @Test
    public void test() {
                char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
                String word = "ABCCED";
//        char[][] board = new char[][] {{'A', 'B'}, {'C', 'D'}};
//        String word = "ABCD";

        System.out.println(exist(board, word));


    }

}
