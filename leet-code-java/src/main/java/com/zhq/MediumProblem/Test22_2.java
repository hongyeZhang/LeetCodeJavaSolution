package com.zhq.MediumProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/1/31
 */
public class Test22_2 {
    public static void main(String[] args) {

        List<String> list = generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }

    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    /** 回溯法，直接给定开始、结束括号的位置
     * @param ans
     * @param cur
     * @param open
     * @param close
     * @param max
     */
    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }



}
