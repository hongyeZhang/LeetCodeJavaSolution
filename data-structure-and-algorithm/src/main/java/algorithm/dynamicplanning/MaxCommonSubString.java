package algorithm.dynamicplanning;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-07-28 20:47
 **/
public class MaxCommonSubString {

    public static void main(String[] args) {
        String str1 = "abc123edf";
        String str2 = "bc123jg";

        System.out.println(maxCommonSubString(str1, str2));

    }

    public static String maxCommonSubString(String str1, String str2) {
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        int len1 = str1Arr.length;
        int len2 = str2Arr.length;

        int[][] matrix = new int[len1][len2];
        int maxLength = 0;
        int endIndex = 0;
        int startIndex = 0;

        // 初始化第一行和第一列的数据
        for (int i = 0; i < str1Arr.length; ++i) {
            if (str2Arr[0] == str1Arr[i]) {
                matrix[i][0] = 1;
            } else {
                matrix[i][0] = 0;
            }
        }
        for (int j = 0; j < str2Arr.length; ++j) {
            if (str1Arr[0] == str2Arr[j]) {
                matrix[0][j] = 1;
            } else {
                matrix[0][j] = 0;
            }
        }

        for (int i = 1; i < str1Arr.length; ++i) {
            for (int j = 1; j < str2Arr.length; ++j) {
                if (str1Arr[i] == str2Arr[j]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    if (matrix[i][j] > maxLength) {
                        maxLength = matrix[i][j];
                        endIndex = j;
                    }
                }
            }
        }

        startIndex = endIndex - maxLength + 1;
        return str2.substring(startIndex, endIndex + 1);
    }

}
