package com.zhq.HardProblem;

import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/2/3
 */
public class Test32_3 {
    public static void main(String[] args) {
        String input = "(())";
        System.out.println(longestValidParentheses(input));
    }

    /**
     * 用栈同时记录匹配的括号和下标的值
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

}
