package com.zhq.HardProblem;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/2/3
 */
public class Test30_2 {
    public static void main(String[] args) {

    }

    /**
     * 假设words数组长度为L，word单词长度为WL,遍历字符串s, 下标记做i，
     * 需要比对的单词起始坐标则为 [i, i+WL, i+2WL ... i+(L-1)*WL]
     * 如果i满足条件，各个单词的第k位之和一定相等
     * 即：words[0][k] + words[1][k] + ... + words[L-1][k] == s[i + k] + s[i+WL + k] + ... + s[i+(L-1)*WL + k]
     * 反之，若对于i，满足后者条件的i则可能为正确结果，这个时候直接校验即可。
     *
     * 作者：luqihang
     * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/solution/jian-dan-you-xiao-lu-de-jie-fa-by-luqihang/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rs = new ArrayList<>();
        if (words == null || words.length == 0) {
            return rs;
        }
        int wLen = words[0].length();
        int wTotalLen = words[0].length() * words.length;
        int sLen = s.length();
        int[] flagArray = new int[wLen];
        for (int i = 0; i < wLen; i++) {
            int flag = 0;
            for (String word : words) {
                flag += word.charAt(i);
            }
            flagArray[i] = flag;
        }

        BitSet bs = new BitSet(words.length);
        for (int i = 0; i <= sLen - wTotalLen; i++) {
            int j = 0;
            for (; j < wLen; j++) {
                int sumFlag = 0;
                for (int k = 0; k < words.length; k++) {
                    sumFlag += s.charAt(i + k * wLen + j);
                }
                if (sumFlag != flagArray[j]) {
                    break;
                }
            }
            if (j == wLen) {
                // 可能匹配
                bs.clear();
                for (int k = 0; k < words.length; k++) {
                    String w = s.substring(i + k * wLen, i + (k + 1) * wLen);
                    int n = 0;
                    for (; n < words.length; n++) {
                        if (!bs.get(n) && words[n].equals(w)) {
                            bs.set(n);
                            break;
                        }
                    }
                    if (n == words.length) {
                        break;
                    }
                }
                if (bs.cardinality() == words.length) {
                    rs.add(i);
                }

            }
        }

        return rs;
    }



}
