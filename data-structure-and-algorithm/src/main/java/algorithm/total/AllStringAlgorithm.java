package algorithm.total;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import datastructure.array.Array;
import javafx.scene.control.TableView;

/**
 * @author : ZHQ
 * @date : 2020/3/8
 */
public class AllStringAlgorithm {

    /**
     * 字符串匹配 ： 暴力匹配
     * 时间复杂度 O(m*n)
     *
     * KMP O(m+n)
     * BM O(n)
     * SUNDAY
     *
     * =============================================================================================
     * @param originStr
     * @param patternStr
     * @return
     */
    public int stringMatch_violentMatch(String originStr, String patternStr) {
        if (originStr.length() < 1 || patternStr.length() < 1) {
            return -1;
        }

        int i = 0, j = 0;
        while (i < originStr.length() && j < patternStr.length()) {
            if (originStr.charAt(i) == patternStr.charAt(j)) {
                // 如果当前字符匹配成功（即S[i] == P[j]），则i++，j++
                i++;
                j++;
            } else {
                // 如果失配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == patternStr.length()) {
            return i - j;
        }

        return -1;
    }

    @Test
    public void testStringMatchViolentMatch() {
        String originStr = "BBCABCDAB";
        String patternStr = "ABCDAB";
        int result = stringMatch_violentMatch(originStr, patternStr);
        Assert.assertEquals(3, result);
    }


    /** KMP 匹配
     * 时间复杂度：O(m+n)
     * =============================================================================================
     * @param originStr
     * @param patternStr
     * @return
     */
    public int stringMatch_KMPMatch(String originStr, String patternStr) {
        if (originStr.length() < 1 || patternStr.length() < 1) {
            return -1;
        }

        int i = 0, j = 0;
        int[] next = getNext(patternStr);
        while (i < originStr.length() && j < patternStr.length()) {
            if (j == -1 || originStr.charAt(i) == patternStr.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == patternStr.length()) {
            return i - j;
        }
        return -1;
    }

    @Test
    public void testStringMatch_KMPMatch() {
        String originStr = "BBC ABCDAB ABCDABCDABDE";
        String patternStr = "ABCDABD";

        int result = stringMatch_KMPMatch(originStr, patternStr);
        Assert.assertEquals(15, result);
    }


    public int[] getNext(String patternStr) {
        int len = patternStr.length();
        int[] next = new int[len];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < len - 1) {
            // p[k]表示前缀，p[j]表示后缀
            if (k == -1 || patternStr.charAt(j) == patternStr.charAt(k)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

        return next;
    }

    // TODO: 2020/4/3   没通过
//    public int[] getNextSecond(String patternStr){
//        int len = patternStr.length();
//        int[] next = new int[len];
//        next[0] = -1;
//        int k = -1;
//        int j = 0;
//        while (j < len - 1) {
//            if (k == -1 || patternStr.charAt(k) == patternStr.charAt(j)) {
//                k++;
//                j++;
//                if (patternStr.charAt(k) != patternStr.charAt(j)) {
//                    next[j] = k;
//                } else {
//                    next[j] = next[next[k]];
//                }
//            } else {
//                k = next[k];
//            }
//        }
//        return next;
//    }



    @Test
    public void testGetNext() {
        String patternStr = "ABCDABD";
        int[] next = getNext(patternStr);
        for (int i : next) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }


    /** 替换字符串中的空格
     * =============================================================================================
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        StringBuilder out = new StringBuilder("");
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                out.append("%20");
            } else {
                out.append(s.charAt(i));
            }
        }
        return out.toString();
    }

    @Test
    public void test() {
        String inputStr = "we are happy";
        System.out.println(replaceSpace(inputStr));
    }


    /** 字符串数组的最长公共前缀
     * =============================================================================================
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
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

    @Test
    public void testLongestCommonPrefix() {
        String[] strs = {"flower", "flow", "flight"};
        String s = longestCommonPrefix(strs);

        System.out.println(s);
    }

    /**
     * 最长回文串
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     *
     * 统计字母出现的次数即可，双数才能构成回文。因为允许中间一个数单独出现，比如“abcba”，所以如果最后有字母落单，总长度可以加 1。
     *
     * =============================================================================================
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                count++;
            } else {
                set.add(s.charAt(i));
            }
        }
        return count * 2 + (set.isEmpty() ? 0 : 1);
    }

    @Test
    public void testLongestPalindrome() {
        String input = "abccccdd";
        System.out.println(longestPalindrome(input));
    }


    /**
     *  验证回文串
     *  给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 两个指针比较头尾。要注意只考虑字母和数字字符，可以忽略字母的大小写。
     * =============================================================================================
     * @param s
     * @return
     */
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

    @Test
    public void testIsPalindrome() {
        String input = "A man, a plan,   a canal: Panama";
        System.out.println(isPalindrome(input));

    }

    private int palindromeStartIndex = 0;

    private int palindromeMaxLen = 0;

    /** 最长回文子串
     *  以某个元素为中心，分别计算偶数长度的回文最大长度和奇数长度的回文最大长度。
     *  =============================================================================================
     * @param s
     * @return
     */
    public String longestPalindromeStr(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); ++i) {
            longestPalindromeHelper(s, i, i);
            longestPalindromeHelper(s, i, i+1);
        }

        return s.substring(palindromeStartIndex, palindromeStartIndex + palindromeMaxLen);
    }

    public void longestPalindromeHelper(String input, int left, int right) {
        while (left >= 0 && right < input.length() && (input.charAt(left) == input.charAt(right))) {
            left--;
            right++;
        }
        if (palindromeMaxLen < right - left - 1) {
            palindromeStartIndex = left + 1;
            palindromeMaxLen = right - left - 1;
        }
    }


    @Test
    public void testLongestPalindromeHelper() {
        String input = "babad";
        String s = longestPalindromeStr(input);
        System.out.println(s);
    }


    /**
     * 最长回文子序列（注意与子串的区别）
     *
     * 动态规划
     * dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
     * otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
     * =============================================================================================
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if (null == s || s.length() < 1) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        // 字符串 [i,j],
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }

    @Test
    public void testLongestPalindromeSubseq() {
        String input = "bbbab";
        System.out.println(longestPalindromeSubseq(input));
    }


    /**
     * 字符串的排列
     * 写一个函数来判断 s2 是否包含 s1 的排列。
     * =============================================================================================
     *
     * 滑动窗口方法
     * 不用真的去算出s1的全排列，只要统计字符出现的次数即可。可以使用一个哈希表配上双指针来做。
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() < 1 || s2.length() < 1 || s1.length() > s2.length()) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int[] count = new int[128];
        for (int i = 0; i < len1; ++i) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (isAllZero(count)) {
            return true;
        }

        // 滑动窗口
        for (int i = len1; i < len2; ++i) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (isAllZero(count)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAllZero(int[] count) {
        for (int i = 0; i < count.length; ++i) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCheckInclusion() {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));

    }


    /** 第一个只出现一次的字符
     *  遍历两边，第一次先统计每个字符的出现次数；第二遍
     * =============================================================================================
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        if (len == 0) {
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(map.containsKey(str.charAt(i))){
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value+1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }
        for(int i = 0; i < len; i++){
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    /** 单词反转
     * =============================================================================================
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s.trim().length() == 0) {
            return s.trim();
        }
        String [] temp = s.trim().split(" +");
        String res = "";
        for(int i = temp.length - 1; i > 0; i--){
            res += temp[i] + " ";
        }
        return res + temp[0];
    }


    /** 旋转字符串
     * 给定两个字符串, A 和 B。 A 的旋转操作就是将 A 最左边的字符移动到最右边。
     * 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
     *
     * =============================================================================================
     * @param A
     * @param B
     * @return
     */
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A+A).contains(B);
    }


    /** 左旋转字符串
     *
     *  在第 n 个字符后面将切一刀，将字符串分为两部分，再重新并接起来即可。注意字符串长度为 0 的情况。
     *  =============================================================================================
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if (len == 0) {
            return "";
        }
        n = n % len;
        String s1 = str.substring(n, len);
        String s2 = str.substring(0, n);
        return s1+s2;
    }


    /** 写一个函数，其作用是将输入的字符串反转过来
     *  =============================================================================================
     * @param s
     * @return
     */
    public String reverseString(String s) {
        if (s.length() < 2) {
            return s;
        }
        int l = 0, r = s.length() - 1;
        char [] strs = s.toCharArray();
        while(l < r){
            char temp = strs[l];
            strs[l] = strs[r];
            strs[r] = temp;
            l++;
            r--;
        }
        return new String(strs);
    }

    /** 字符串转化为整数
     *  注意：整数溢出的规则即可
     *  特殊规则的处理  每个题目各不相同
     * =============================================================================================
     * @param str
     * @return
     */
    public int strToInt(String str) {
        if (str == null){ return 0;}
        if(str.length()==0){ return 0;}
        // 去除空白
        str = str.trim();
        if (str.length()==0){ return 0;}

        char c = str.charAt(0);
        if (c != '+' && c != '-' && (c < '0' || c > '9')) {
            return 0;
        }
        // 结尾的序号
        int end = str.length() - 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                end = i - 1;
                break;
            }
        }
        if(end == 0 && (str.charAt(0)=='+'||str.charAt(0)=='-')){ return 0;}
        String res = str.substring(0, end + 1);
        try {
            return new Integer(res);
        } catch (Exception e) {
            return res.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }


    /** 字符串 正则表达式匹配
     * 没看懂  需要继续看
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*' && dp[0][j-1]) {
                dp[0][j+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }



    /**
     * 3. 无重复字符的最长子串
     *
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        // len >= 2
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] dp = new int[len];
        dp[0] = 1;
        if (chars[0] == chars[1]) {
            dp[1] = 1;
        } else {
            dp[1] = 2;
        }
        int max = Math.max(dp[0], dp[1]);

        if (len > 2) {
            for (int i = 2; i < len; ++i) {
                String prefix = getPrefix(s, i - 1, dp[i - 1]);
                if (prefix.contains(String.valueOf(s.charAt(i)))) {
                    dp[i] = getUniqueNum(prefix, s.charAt(i));
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }

    public String getPrefix(String str, int endIndex, int length) {
        int startIndex = endIndex + 1 - length;
        return str.substring(startIndex, endIndex + 1);
    }

    public int getUniqueNum(String input, char c) {
        return input.length() - input.lastIndexOf(c);
    }

    @Test
    public void testLengthOfLongestSubstring() {
        String input = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(input));

    }































































}
