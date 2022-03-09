package com.zhq.HardProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/28 13:20
 */
public class Test51_2 {


    /**
     * 经典的回溯法应用
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        List<List<String>> retList = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] = '.';
            }
        }
        backTrack(retList, board, 0);
        return retList;
    }


    public void backTrack(List<List<String>> retList, char[][] board, int row) {
        if (row == board.length) {
            List<String> tmpList = new ArrayList<>();
            for (char[] chars : board) {
                tmpList.add(new String(chars));
            }
            retList.add(tmpList);
            return;
        }
        // 遍历每列获得结果
        for (int i = 0; i < board.length; ++i) {
            if (!isValid(board, row, i)) {
                continue;
            }
            board[row][i] = 'Q';
            backTrack(retList, board, row + 1);
            board[row][i] = '.';
        }
    }

    public boolean isValid(char[][] board, int row, int col) {
        // 检查所有的列
        for (int i = 0; i < row; ++i) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查左上角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 检查右上角
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test() {
        List<List<String>> retList = solveNQueens(8);
        for (List<String> strings : retList) {
            for (String string : strings) {
                System.out.print(string + "\t");
            }
            System.out.println();
            System.out.println("==================");
        }
    }


}
