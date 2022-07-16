package com.zhq.HardProblem;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/4/19 10:16
 */
public class Test887 {


    public int superEggDrop(int k, int n) {
        Map<String, Integer> memo = new HashMap<>();
        return dp(k, n, memo);
    }

    /**
     * 超出时间限制了
     * @param K
     * @param N
     * @param memo
     * @return
     */
    public int dp(int K, int N, Map<String, Integer> memo) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        String key = K + "-" + N;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; ++i) {
            res = Math.min(res, Math.max(dp(K, N - i, memo), dp(K - 1, i - 1, memo)) + 1);
        }
        memo.put(key, res);
        return res;
    }

    @Test
    public void test() {
        System.out.println(superEggDrop(3,14));
    }

}
