package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class Interview12 {



    /** 回溯法的经典应用
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        if (null == board || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] visitedFlag = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (hasPathCore(board, i, j, row, col, 0, visitedFlag, word)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean hasPathCore(char[][] board, int row, int col,int rowMax,
                    int colMax, int pathLen, boolean[][] visitedFlag, String word) {
        if (pathLen == word.length()) {
            return true;
        }

        boolean hasPath = false;
        if ((row >= 0 && row < rowMax) && (col >= 0 && col < colMax) && board[row][col] == word
                        .charAt(pathLen) && !visitedFlag[row][col]) {
            pathLen++;
            visitedFlag[row][col] = true;
            hasPath = hasPathCore(board, row - 1, col, rowMax, colMax, pathLen, visitedFlag, word)
                            || hasPathCore(board, row, col - 1, rowMax, colMax, pathLen,
                            visitedFlag, word) || hasPathCore(board, row + 1, col, rowMax, colMax,
                            pathLen, visitedFlag, word) || hasPathCore(board, row, col + 1, rowMax,
                            colMax, pathLen, visitedFlag, word);
            if (!hasPath) {
                pathLen--;
                visitedFlag[row][col] = false;
            }
        }

        return hasPath;
    }

    public static void main(String[] args) {
//        char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";
        char[][] board = new char[][] {{'A', 'B'}, {'C', 'D'}};
        String word = "ABCD";

        System.out.println(exist(board, word));



    }



}
