package com.zhq.MediumProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/1/30
 */
public class Test17 {

    private static String[] letterMap = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String input = "234";
        letterCombinations(input);
        System.out.println("combination over");
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }



    }

    public static List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        doCombination(digits, 0, "");
        return result;
    }

    public static void doCombination(String digits, int index, String singleStr) {
        if (index == digits.length()) {
            result.add(singleStr);
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); ++i) {
            doCombination(digits, index + 1, singleStr + letters.charAt(i));
        }
    }




}
