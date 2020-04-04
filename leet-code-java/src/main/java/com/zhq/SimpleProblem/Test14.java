package com.zhq.SimpleProblem;

import java.util.Arrays;

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

    /** 先排序，再取排序第一位和最后一位的公共子串
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        int len = strs.length;
        Arrays.sort(strs);
        String firstStr = strs[0];
        String lastStr = strs[len - 1];
        StringBuilder common = new StringBuilder("");
        int i = 0, j = 0;
        while (i < firstStr.length() && j < lastStr.length() && firstStr.charAt(i) == lastStr
                        .charAt(j)) {
            common.append(firstStr.charAt(i));
            i++;
            j++;
        }

        return common.toString();

    }

}
