package algorithm.dynamicplanning;

import java.util.Set;
import java.util.TreeSet;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-07-28 21:07
 **/
public class MaxCommonSubSequence {

    private static String STR1 = "BDCABA";
    private static String STR2 = "ABCBDAB";

    private static TreeSet<String> set = new TreeSet<String>();


    public static void main(String[] args) {

        int len1 = STR1.length();
        int len2 = STR2.length();

        int[][] matrix = new int[len1][len2];

        calculateMatrix(matrix);

        // 输出表的存储结果
        System.out.println("最大公共子序列的长度为 ： " + matrix[len1 - 1][len2 - 1]);
        for (int i = 0; i < len1; ++i) {
            for (int j = 0; j < len2; ++j) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // 输出所有的最长子序列（可能有多个）
        traceBack(len1 - 1, len2 - 1, matrix, "");
        System.out.println("最大公共子序列的个数为 : " + set.size());

        set.forEach(str -> {
            System.out.println(str);
        });
    }

    public static void calculateMatrix(int[][] matrix) {
        int len1 = STR1.length();
        int len2 = STR2.length();

        char[] str1Arr = STR1.toCharArray();
        char[] str2Arr = STR2.toCharArray();

        // 初始化第一列
        for (int i = 0; i < len1; ++i) {
            if (str1Arr[i] == str2Arr[0]) {
                matrix[i][0] = 1;
                while (i < len1) {
                    matrix[i++][0] = 1;
                }
                break;
            }
        }

        // 初始化第一行
        for (int j = 0; j < len2; ++j) {
            if (str2Arr[j] == str1Arr[0]) {
                matrix[0][j] = 1;
                while (j < len2) {
                    matrix[0][j++] = 1;
                }
                break;
            }
        }

        for (int i = 1; i < len1; ++i) {
            for (int j = 1; j < len2; ++j) {
                if (str1Arr[i] == str2Arr[j]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
    }


    /**
     * @Description: 我们需要在动态规划表上进行回溯 —— 从table[m][n]，即右下角的格子，开始进行判断：
     *
     *     如果格子table[i][j]对应的X[i-1] == Y[j-1]，则把这个字符放入 LCS 中，并跳入table[i-1][j-1]中继续进行判断；
     *
     *     如果格子table[i][j]对应的 X[i-1] ≠ Y[j-1]，则比较table[i-1][j]和table[i][j-1]的值，跳入值较大的格子继续进行判断；
     *
     *     直到 i 或 j 小于等于零为止，倒序输出 LCS 。
     *
     * 如果出现table[i-1][j]等于table[i][j-1]的情况，说明最长公共子序列有多个，故两边都要进行回溯（这里用到递归）
     **/
    public static void traceBack(int rowIndex, int colIndex, int[][] matrix, String str) {
        while (rowIndex >= 0 && colIndex >= 0) {
            if (STR1.charAt(rowIndex) == STR2.charAt(colIndex)) {
                str += STR1.charAt(rowIndex);
                --rowIndex;
                --colIndex;
            } else {
                if (matrix[rowIndex - 1][colIndex] > matrix[rowIndex][colIndex - 1]) {
                    rowIndex--;
                } else if (matrix[rowIndex - 1][colIndex] < matrix[rowIndex][colIndex - 1]) {
                    colIndex--;
                } else {
                    traceBack(rowIndex - 1, colIndex, matrix, str);
                    traceBack(rowIndex, colIndex - 1, matrix, str);
                    return;
                }
            }
        }
        set.add(reverseString(str));
    }

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }




}
