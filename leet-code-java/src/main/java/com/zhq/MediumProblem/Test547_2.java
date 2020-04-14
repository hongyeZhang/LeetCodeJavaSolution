package com.zhq.MediumProblem;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test547_2 {

    int[] alphabet = new int[26];

    /**
     * 连通区域问题
     *
     * 1101. 彼此熟识的最早时间；
     * 1061. 按字典序排列最小的等效字符串；
     * 1135. 最低成本联通所有城市；
     * 737. 句子相似性 II。
     *
     * @param A
     * @param B
     * @param S
     * @return
     */
    public String smallestEquivalentString(String A, String B, String S) {
        for (int i = 0; i < 26; ++i) {
            alphabet[i] = i;
        }

        for (int i = 0; i < A.length(); i++) {
            union(A.charAt(i) - 'a', B.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            sb.append((char) (findSmall(c - 'a') + 'a'));
        }

        return sb.toString();
    }

    private int findSmall(int i) {
        while (alphabet[i] != i) {
            i = alphabet[i];
        }

        return i;
    }

    private void union(int a, int b) {
        int aa = findSmall(a);
        int bb = findSmall(b);
        int small = Math.min(aa, bb);

        alphabet[bb] = small;
        alphabet[aa] = small;
    }

}
