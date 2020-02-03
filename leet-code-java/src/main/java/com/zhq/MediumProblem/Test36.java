package com.zhq.MediumProblem;

import java.util.HashMap;

/**
 * @author : ZHQ
 * @date : 2020/2/3
 */
public class Test36 {
    public static void main(String[] args) {


        char[] arr0 = {'5','3','.','.','7','.','.','.','.'};
        char[] arr1 = {'6','.','.','1','9','5','.','.','.'};
        char[] arr2 = {'.','9','8','.','.','.','.','6','.'};
        char[] arr3 = {'8','.','.','.','6','.','.','.','3'};
        char[] arr4 = {'4','.','.','8','.','3','.','.','1'};
        char[] arr5 = {'7','.','.','.','2','.','.','.','6'};
        char[] arr6 = {'.','6','.','.','.','.','2','8','.'};
        char[] arr7 = {'.','.','.','4','1','9','.','.','5'};
        char[] arr8 = {'.','.','.','.','8','.','.','7','9'};

        char[][] board = new char[9][9];
        board[0] = arr0;
        board[1] = arr1;
        board[2] = arr2;
        board[3] = arr3;
        board[4] = arr4;
        board[5] = arr5;
        board[6] = arr6;
        board[7] = arr7;
        board[8] = arr8;

        System.out.println(isValidSudoku(board));

    }

    /**
     * 关键在于寻找子数独的下标
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>(16);
            columns[i] = new HashMap<>(16);
            boxes[i] = new HashMap<>(16);
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    // 关键点！！！
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }



}
