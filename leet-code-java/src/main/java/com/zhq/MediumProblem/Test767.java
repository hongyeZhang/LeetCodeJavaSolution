package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/26
 */
public class Test767 {

    /**
     * 基本思路： 先全排列，再判断每个字符串是否具有相邻的字符
     *
     *  没有 AC
     *  超出内存限制
     *
     *
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        if (null == S || S.length() == 0) {
            return "";
        } else if (S.length() == 1) {
            return S;
        }

        List<String> allPermutationList = new ArrayList<>();
        char[] chars = S.toCharArray();
        allPermutationCore(chars, 0, allPermutationList);
        for (String s : allPermutationList) {
            if (!hasAdjacentCharacter(s)) {
                return s;
            }
        }

        return "";
    }

    public void allPermutationCore(char[] chars, int currentIndex, List<String> allPermutationList) {
        if (currentIndex == chars.length - 1) {
            allPermutationList.add(new String(chars));
        } else {
            for (int i = currentIndex; i < chars.length; ++i) {
                swap(chars, currentIndex, i);
                allPermutationCore(chars, currentIndex + 1, allPermutationList);
                swap(chars, currentIndex, i);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public boolean hasAdjacentCharacter(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length - 1; ++i) {
            if (chars[i] == chars[i + 1]) {
                return true;
            }
        }
        return false;
    }



    @Test
    public void test() {
        String input = "aaab";
        System.out.println(reorganizeString(input));
    }

}
