package com.zhq.MediumProblem;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/7/17 14:51
 */
public class Test877 {

    /**
     * 先手必赢
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        return true;
    }


    /**
     * 关于挑石头博弈问题的通用解法
     * from labuladong的算法小抄
     * @param piles
     * @return 先手和后手得分的差值
     */
    public int stoneGameCommon(int[] piles) {
        if (piles == null || piles.length == 0) {
            return 0;
        }
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        // init
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = new Pair(0, 0);
            }
        }
        // base case
        for (int i = 0; i < n; ++i) {
            dp[i][i].first = piles[i];
            dp[i][i].second = 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int left = piles[i] + dp[i + 1][j].second;
                int right = piles[j] + dp[i][j - 1].second;
                if (left > right) {
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i + 1][j].first;
                } else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j - 1].first;
                }
            }
        }
        Pair ret = dp[0][n - 1];
        return ret.first - ret.second;
    }


    class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


}
