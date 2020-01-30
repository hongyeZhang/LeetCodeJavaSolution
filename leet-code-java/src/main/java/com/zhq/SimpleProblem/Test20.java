package com.zhq.SimpleProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/1/30
 */
public class Test20 {

    static Map<Character, Character> map = new HashMap<>();
    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public static void main(String[] args) {
        String input = "()";
        System.out.println(isValid(input));
    }

    /**
     * 如果有匹配的元素，则出栈，如果最后栈为空，则括号表达式是有效的表达式
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 匹配
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


}
