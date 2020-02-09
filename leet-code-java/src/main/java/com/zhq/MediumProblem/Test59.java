package com.zhq.MediumProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class Test59 {
    public static void main(String[] args) {
        int n = 3;
        int[][] ints = generateMatrix(n);
        for (int i = 0; i < ints.length; ++i) {
            for (int j = 0; j < ints[i].length; ++j) {
                System.out.print(ints[i][j] + "\t");
            }
            System.out.println();
        }

    }

    /**
     * 参考官方答案，模拟法，未深究
     * https://leetcode-cn.com/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) {
                mat[t][i] = num++; // left to right.
            }
            t++;
            for(int i = t; i <= b; i++) {
                mat[i][r] = num++; // top to bottom.
            }
            r--;
            for(int i = r; i >= l; i--) {
                mat[b][i] = num++; // right to left.
            }
            b--;
            for(int i = b; i >= t; i--) {
                mat[i][l] = num++; // bottom to top.
            }
            l++;
        }
        return mat;
    }


}
