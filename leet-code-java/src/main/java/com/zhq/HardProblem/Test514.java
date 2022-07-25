package com.zhq.HardProblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/7/20 10:03
 */
public class Test514 {

    Map<Character, ArrayList<Integer>> keyIndexMap;
    int[][] memo;

    public int findRotateSteps(String ring, String key) {
        if (ring == null || ring.length() == 0 || key == null || key.length() == 0) {
            return 0;
        }
        int m = ring.length();
        int n = key.length();
        keyIndexMap = new HashMap<>();
        memo = new int[m][n];
        for (int[] rows : memo) {
            Arrays.fill(rows, -1);
        }

        for (int i = 0; i < ring.length(); ++i) {
            keyIndexMap.putIfAbsent(ring.charAt(i), new ArrayList<>());
            keyIndexMap.get(ring.charAt(i)).add(i);
        }
        return dp(ring, 0, key, 0);
    }

    /**
     * dp(ring,i,key,j) 表示当装盘指向 ring[i] 时，输入 key[j...] 字符串需要转动的最小次数
     * @param ring
     * @param i
     * @param key
     * @param j
     * @return
     */
    public int dp(String ring, int i, String key, int j) {
        if (j == key.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int length = ring.length();
        int res = Integer.MAX_VALUE;
        ArrayList<Integer> indexList = keyIndexMap.get(key.charAt(j));
        for (Integer index : indexList) {
            int delta = Math.abs(index - i);
            delta = Math.min(delta, length - delta);
            int subProblem = dp(ring, index, key, j + 1);
            res = Math.min(res, 1 + delta + subProblem);
        }
        memo[i][j] = res;
        return res;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, findRotateSteps("godding", "gd"));
        Assert.assertEquals(13, findRotateSteps("godding", "godding"));
    }

}
