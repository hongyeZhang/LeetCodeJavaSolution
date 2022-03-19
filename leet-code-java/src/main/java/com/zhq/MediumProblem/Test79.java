package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Stack;

/**
 * @author ZHQ
 * @date 2022/3/1
 */
public class Test79 {

    /**
     *
     * 深度优先遍历，记录下访问的路径即可
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board[0].length == 0) {
            return false;
        }
        int rowMax = board.length;
        int colMax = board[0].length;
        boolean[][] used = new boolean[rowMax][colMax];
        for (int i = 0; i < rowMax; ++i) {
            for (int j = 0; j < colMax; ++j) {
                if (dfs(board, i, j, used, word.toCharArray(), 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int col, boolean[][] used, char[] words, int index) {
        if (index == words.length) {
            return true;
        }
        int rowMax = board.length;
        int colMax = board[0].length;
        if (row < 0 || row >= rowMax || col < 0 || col >= colMax || board[row][col] != words[index] || used[row][col]) {
            return false;
        }
        used[row][col] = true;
        boolean res =  dfs(board, row - 1, col, used, words, index + 1)
                || dfs(board, row + 1, col, used, words, index + 1)
                || dfs(board, row, col - 1, used, words, index + 1)
                || dfs(board, row, col + 1, used, words, index + 1);
        if (res) {
            return true;
        }
        used[row][col] = false;
        return false;
    }


    @Test
    public void test() {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        boolean exist = exist(board, word);
        System.out.println(exist);


    }
}
