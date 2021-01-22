package com.zhq.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * N 皇后
 * 回溯算法
 * @Author: ZHQ
 * @Date: 2020/12/16
 */
public class Test51 {

    public List<List<String>> solveNQueens(int n) {
        char[][] currentBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                currentBoard[i][j] = '.';
            }
        }

        List<List<String>> retList = new ArrayList<>();
        backtrack(currentBoard, 0, retList);

        for (List<String> strings : retList) {
            System.out.println(strings);
        }
        return retList;
    }


    public void backtrack(char[][] currentBoard, int row, List<List<String>> retList) {
        if (row == currentBoard.length) {
            List<String> tmpList = new ArrayList<>();
            for (char[] chars : currentBoard) {
                tmpList.add(String.valueOf(chars));
            }
            retList.add(tmpList);
            return;
        }

        for (int i = 0; i < currentBoard.length; i++) {
            if (!isValidChoice(currentBoard, row, i)) {
                continue;
            }
            currentBoard[row][i] = 'Q';
            backtrack(currentBoard, row + 1, retList);
            currentBoard[row][i] = '.';
        }
    }

    public boolean isValidChoice(char[][] currentBoard, int row, int col) {
        // 同一列上是否存在冲突
        for (int i = 0; i < row; i++) {
            if (currentBoard[i][col] == 'Q') {
                return false;
            }
        }
        // 右上对角线是否存在冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < currentBoard.length; i--, j++) {
            if (currentBoard[i][j] == 'Q') {
                return false;
            }
        }
        // 左上对角线是否存在冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (currentBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test() {
        solveNQueens(4);
    }





}
