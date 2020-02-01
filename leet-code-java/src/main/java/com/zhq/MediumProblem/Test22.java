package com.zhq.MediumProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/1/31
 */
public class Test22 {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> combinationList = new ArrayList<>();
        generateAllCombinations(new char[2 * n], 0, combinationList);
        return combinationList;
    }

    /** 暴力求解，递归产生每一个值，并判断该值是否符合要求
     * @param current
     * @param pos
     * @param result
     */
    public static void generateAllCombinations(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (isValid(current)) {
                result.add(String.valueOf(current));
            }
        } else {
            current[pos] = '(';
            generateAllCombinations(current, pos + 1, result);
            current[pos] = ')';
            generateAllCombinations(current, pos + 1, result);
        }
    }

    /** 检查两边的括号是否对称，即产生的括号组合是否有效
     * @param sequence
     * @return
     */
    public static boolean isValid(char[] sequence) {
        int balance = 0;
        for (char c : sequence) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

}
