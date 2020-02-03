package com.zhq.HardProblem;

import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/2/3
 */
public class Test32 {
    public static void main(String[] args) {
        String input = "(()";
//        System.out.println(isValidParentheses(input));
        System.out.println(longestValidParentheses(input));
    }

    /**
     * 暴力搜索法（超出时间限制）
     * 考虑给定字符串中每种可能的非空偶数长度子字符串，检查它是否是一个有效括号字符串序列。
     * 为了检查有效性，我们使用栈的方法。
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i + 2; j <= s.length(); j = j + 2) {
                if (isValidParentheses(s.substring(i, j))) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    public static boolean isValidParentheses(String input) {
        if (input.length() <= 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); ++i) {
            Character c = input.charAt(i);
            if (c.equals('(')) {
                stack.push(c);
            } else if (c.equals(')') && !stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
