package com.zhq.HardProblem;

import java.util.*;

/**
 * @author : ZHQ
 * @date : 2020/2/2
 */
public class Test30 {

    public static void main(String[] args) {
        String s = "foobarfoobar";
        String[] words = {"foo", "bar"};
        List<Integer> substring = findSubstring(s, words);
        System.out.println(substring);
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        // 获得words的全排列组合，再查看所有的组合的字符串匹配情况
        List<List<String>> permResult = new ArrayList<>();
        stringPerm(words, new Stack<>(), permResult);
        List<String> combinationResult = new ArrayList<>();
        for (List<String> list : permResult) {
            StringBuilder sb = new StringBuilder();
            for (String s1 : list) {
                sb.append(s1);
            }
            combinationResult.add(sb.toString());
        }

        Set<Integer> indexSet = new HashSet<>();
        for (String s1 : combinationResult) {
            indexSet.addAll(searchAllIndex(s, s1));
        }
        return new ArrayList<>(indexSet);
    }

    public static List<Integer> searchAllIndex(String str, String key) {
        List<Integer> res = new ArrayList<>();
        int index = str.indexOf(key);
        while (index != -1) {
            res.add(index);
            index = str.indexOf(key, index + 1);
        }
        return res;
    }

    public static void stringPerm(String[] array, Stack<String> stack, List<List<String>> res) {
        if (array.length <= 0) {
            List<String> tmpList = new ArrayList<>();
            tmpList.addAll(stack);
            res.add(tmpList);
        } else {
            for (int i = 0; i < array.length; i++) {
                String[] tempArray = new String[array.length - 1];
                System.arraycopy(array, 0, tempArray, 0, i);
                System.arraycopy(array, i + 1, tempArray, i, array.length - i - 1);
                stack.push(array[i]);
                stringPerm(tempArray, stack, res);
                stack.pop();
            }
        }
    }


}
