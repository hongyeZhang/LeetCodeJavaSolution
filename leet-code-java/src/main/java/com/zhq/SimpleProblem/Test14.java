package com.zhq.SimpleProblem;

/**
 * @author : ZHQ
 * @date : 2020/1/30
 */
public class Test14 {

    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"aa", "a"};
        System.out.println(longestCommonPrefix(strs));


    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        } else if (strs.length > 1) {
            String commonSubStr = "";
            String first = strs[0];
            boolean addFlag = true;
            for (int i = 0; i < first.length(); ++i) {
                Character character = first.charAt(i);
                for (int index = 1; index < strs.length; ++index) {
                    // 不一定第一个选中的字符串是最短的，因此需要判断字符串是否超长
                    if (i >= strs[index].length()) {
                        addFlag = false;
                    } else {
                        if (!character.equals(strs[index].charAt(i))) {
                            addFlag = false;
                        }
                    }
                }
                if (addFlag) {
                    commonSubStr += String.valueOf(character);
                } else {
                    break;
                }
            }
            return commonSubStr;
        }
        return "";
    }

}
