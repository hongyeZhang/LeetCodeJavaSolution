package com.zhq.SimpleProblem;

/**
 * @author : ZHQ
 * @date : 2020/4/3
 */
public class Test125 {

    public boolean isPalindrome(String s) {
        if (null == s || s.length() <= 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;

    }


}
