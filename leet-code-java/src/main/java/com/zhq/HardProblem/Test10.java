package com.zhq.HardProblem;

/**
 * @program: LeetCodeTest
 * @description: 正则表达式匹配
 * @author: ZHQ
 * @create: 2019-05-25 17:47
 **/
public class Test10 {

    public static void main(String[] args) {

    }

    /** 参考别人题解
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first_match = (!s.isEmpty() &&
                        (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s, p.substring(2)) ||
                            (first_match && isMatch(s.substring(1), p)));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}
