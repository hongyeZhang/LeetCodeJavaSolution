package com.zhq.HardProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/3
 */
public class Test32_2 {
    public static void main(String[] args) {
        String input = ")()())";
        System.out.println(longestValidParentheses(input));
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }



}
