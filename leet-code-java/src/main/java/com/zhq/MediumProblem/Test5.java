package com.zhq.MediumProblem;

/**
 * @program: LeetCodeTest
 * @description: 最长回文子串
 * @author: ZHQ
 * @create: 2018-10-21 22:24
 **/
public class Test5 {


    /**
     * @Description: 暴力解法，超出时间限制
     * @Param: [s]
     * @return: java.lang.String
     * @Author: ZHQ
     * @Date: 2018/10/21
     **/
    public static String longestPalindrome(String s) {

        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }

        int subLength = 0;
        String maxSubString = "";
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i + 1; j < s.length(); ++j) {
                int len = j - i + 1;
                String tempStr = s.substring(i, j + 1);
                if (isPalindrome(tempStr)) {
                    if (len > subLength) {
                        subLength = len;
                        maxSubString = tempStr;
                    }
                }
            }
        }

        if ("".equals(maxSubString)) {
            maxSubString = s.substring(0, 1);
        }

        return maxSubString;
    }

    public static boolean isPalindrome(String s) {


/*        //  判断回文字符串，只需要将字符串逆向输出，然后判断二者是否相等
        String k=s.substring(i,j);
        String rk=new StringBuffer(k).reverse().toString();
        if(k.equals(rk)&&k.length()>res.length()){
            res=k;
        }*/

        int length = s.length();
        if (length % 2 == 0) {
            //偶数
            for (int i = 0; i < (length / 2); ++i) {
                if (s.charAt(i) != s.charAt(length - 1 - i)) {
                    return false;
                }
            }
        } else {
            //奇数
            for (int i = 0; i < (length - 1) / 2; ++i) {
                if (s.charAt(i) != s.charAt(length - 1 - i)) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * @Description: 最长回文子串，最基本的动态规划解法，还有更加优化的方法
     * @Param: [s]
     * @return: java.lang.String
     * @Author: ZHQ
     * @Date: 2019/5/19
     **/
    public static String longestPalindromeByDynamicPlanning(String s) {
        if (s.isEmpty()) {
            return s;
        }

        int length = s.length();
        // Longest Palindromic Subsequence
        boolean[][] LPS = new boolean[length][length];
        int maxLen = 1;
        int start = 0;
        for (int endIndex = 0; endIndex < length; ++endIndex) {
            for (int startIndex = 0; startIndex <= endIndex; ++startIndex) {
                if (endIndex - startIndex < 2) {
                    // 单个字母和两个字母的字符串需要单独处理
                    LPS[startIndex][endIndex] = (s.charAt(startIndex) == s.charAt(endIndex));
                } else {
                    LPS[startIndex][endIndex] = (s.charAt(endIndex) == s.charAt(startIndex)) && LPS[startIndex + 1][endIndex - 1];
                }
                if (LPS[startIndex][endIndex] && endIndex - startIndex + 1 > maxLen) {
                    maxLen = endIndex - startIndex + 1;
                    start = startIndex;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }


    public static void main(String[] args) {

        String input = "babad";
//        System.out.println(longestPalindrome(input));
        System.out.println(longestPalindromeByDynamicPlanning(input));

    }


}
