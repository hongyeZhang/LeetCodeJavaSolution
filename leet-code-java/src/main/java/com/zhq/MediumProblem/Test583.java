package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/20 16:57
 */
public class Test583 {

    public int minDistance(String word1, String word2) {
        int commonLen = longestCommonSubseq(word1, word2);
        return word1.length() - commonLen + word2.length() - commonLen;
    }

    public int longestCommonSubseq(String word1, String word2) {
        if (word1 == null || word1.length() == 0 || word2 == null || word2.length() == 0) {
            return 0;
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        String word1 = "leetcode";
        String word2 = "etco";
        System.out.println(minDistance(word1, word2));

    }

}
