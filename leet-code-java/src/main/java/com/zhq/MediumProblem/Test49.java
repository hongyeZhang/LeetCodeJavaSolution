package com.zhq.MediumProblem;

import javafx.scene.chart.StackedAreaChart;

import java.util.*;

/**
 * @author : ZHQ
 * @date : 2020/2/7
 */
public class Test49 {
    public static void main(String[] args) {
//        String str = "eat";
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < str.length(); ++i) {
//            set.add(Character.valueOf(str.charAt(i)));
//        }
//        System.out.println(set);

        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagramsSecond(input);
        for (List<String> list : lists) {
            System.out.println(list);
        }


    }

    /** 先排序，再将排好序的string做为map的key，然后进行存储
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0){ return new ArrayList();}

        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)){ ans.put(key, new ArrayList());}

            ans.get(key).add(s);
        }

        return new ArrayList(ans.values());
    }

    /** 自己之前的思路，感觉是对的，不知道哪里错了
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagramsSecond(String[] strs) {
        Map<Set<Character>, List<String>> map = new HashMap<>();

        for (String str : strs) {
            Set<Character> characterSet = transferToSet(str);
            if (!map.containsKey(characterSet)) {
                List<String> tmpList = new ArrayList<>();
                tmpList.add(str);
                map.put(characterSet, tmpList);
            } else {
                map.get(characterSet).add(str);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Set<Character> characters : map.keySet()) {
            res.add(map.get(characters));
        }

        return res;
    }

    public static Set<Character> transferToSet(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); ++i) {
            set.add(Character.valueOf(str.charAt(i)));
        }
        return set;
    }

}
