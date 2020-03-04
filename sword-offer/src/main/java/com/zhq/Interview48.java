package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/3
 */
public class Interview48 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        // len > 2 时
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] dp = new int[len];
        dp[0] = 1;
        if (chars[0] == chars[1]) {
            dp[1] = 1;
        } else {
            dp[1] = 2;
        }
        int max = Math.max(dp[0], dp[1]);

        if (len > 2) {
            for (int i = 2; i < len; ++i) {
                String prefix = getPrefix(s, i - 1, dp[i - 1]);
                if (prefix.contains(String.valueOf(s.charAt(i)))) {
                    dp[i] = findUniqueLength(prefix, s.charAt(i));
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }

    public static String getPrefix(String wholeStr, int endIndex, int length) {
        int startIndex = endIndex - length + 1;
        return wholeStr.substring(startIndex, endIndex + 1);
    }

    public static int findUniqueLength(String input, char c) {
        return input.length() - input.lastIndexOf(c);
    }



    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(input));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));


//        String str = "adhc";
//        char c = 'd';
//        System.out.println(findUniqueLength(str, c));



    }

}
