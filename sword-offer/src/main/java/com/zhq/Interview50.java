package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/4
 */
public class Interview50 {

    public static char firstUniqChar(String s) {
        if (s.equals("")) {
            return ' ';
        }
        //创建‘a'-'z'的字典
        int[] target = new int[26];
        //第一次遍历，将字符统计到字典数组
        for (int i = 0; i < s.length(); i++) {
            target[s.charAt(i) - 'a']++;
        }
        //第二次遍历，从字典数组获取次数
        for (int i = 0; i < s.length(); i++) {
            if (target[s.charAt(i) - 'a'] == 1){ return s.charAt(i);}
        }

        return ' ';
    }

    public static void main(String[] args) {
//        String input = "abaccdeff";
        String input = "leetcode";

        System.out.println(firstUniqChar(input));


    }
}
