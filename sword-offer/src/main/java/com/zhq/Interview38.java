package com.zhq;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : ZHQ
 * @date : 2020/4/3
 */
public class Interview38 {

    public String[] permutation(String s) {
        List<String> retList = new ArrayList<>();
        char[] chars = s.toCharArray();
        permutationCore(chars, 0, chars.length, retList);

        // 字母去重
        Set<String> set = new HashSet<>(retList);
        String[] strings = new String[set.size()];

        int i = 0;
        for (String s1 : set) {
            strings[i++] = s1;
        }
        return strings;
    }

    public static void permutationCore(char[] chars, int index, int length, List<String> retList) {
        if (index == length - 1) {
            StringBuilder sb = new StringBuilder();
            for (char aChar : chars) {
                sb.append(aChar);
            }
            retList.add(sb.toString());
        } else {
            for (int i = index; i < length; ++i) {
                swap(chars, index, i);
                permutationCore(chars, index + 1, length, retList);
                swap(chars, index, i);
            }
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }


    @Test
    public void test() {
        String input = "abc";

        String[] permutation = permutation(input);

        for (String s : permutation) {
            System.out.println(s);
        }
    }
}
