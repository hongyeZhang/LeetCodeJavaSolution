package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/19 15:33
 */
public class Test524 {

    /**
     * 双指针
     * 先判断子序列，再判断字母排序
     *
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        if (s == null || dictionary.isEmpty()) {
            return "";
        }
        String retStr = "";
        for (String template : dictionary) {
            if (match(s, template)) {
                if (retStr.isEmpty()) {
                    retStr = template;
                } else {
                    if (template.length() > retStr.length() ||
                            (template.length() == retStr.length() && retStr.compareTo(template) > 0)) {
                        retStr = template;
                    }
                }
            }
        }
        return retStr;
    }

    /**
     * 判断 template 是否是 input 的子序列
     * @param input
     * @param template
     * @return
     */
    public boolean match(String input, String template) {
        if (input.length() < template.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < input.length() && j < template.length()) {
            if (input.charAt(i) == template.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j <= template.length() - 1) {
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        List<String> dic = Arrays.asList("ale", "apple", "monkey", "plea");
        String s = "abpcplea";
        String longestWord = findLongestWord(s, dic);
        System.out.println(longestWord);
    }


}
