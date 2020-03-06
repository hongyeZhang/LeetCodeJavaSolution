package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/5
 */
public class Interview60_2 {

    /**
     * 最基本的动态规划解法
     * 还可以优化为仅用两个数组
     * @param n
     * @return
     */
    public static double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        //边界条件
        for (int s = 1; s <= 6; s++) {
            dp[1][s] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int s = i; s <= 6 * i; s++) {
                //求dp[i][s]
                for (int d = 1; d <= 6; d++) {
                    if (s - d < 0) {
//                    if (s - d < i-1) {
                        break;//为0了
                    }
                    dp[i][s] += dp[i - 1][s - d];
                }
            }
        }
        double total = Math.pow((double) 6, (double) n);
        double[] ans = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / total;
        }
        return ans;
    }

    public static void main(String[] args) {
        double[] doubles = twoSum(2);
        for (double aDouble : doubles) {
            System.out.print(aDouble + "\t");
        }

    }


}
