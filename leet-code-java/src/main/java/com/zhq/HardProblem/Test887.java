package com.zhq.HardProblem;

import org.junit.Assert;
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
     * 方法1：利用递归的包里解法
     * @param K
     * @param N
     * @return
     */
    public int recursive(int K, int N) {
        if (K == 1 || N == 0 || N == 1) {
            return N;
        }
        int min = N;
        for (int i = 1; i <= N; ++i) {
            int tmpMin = Math.max(recursive(K - 1, i - 1), recursive(K, N - i));
            min = Math.min(tmpMin + 1, min);
        }
        return min;
    }

    /**
     * 方法2：备忘录方法，解决重复计算的问题
     * 空间复杂度O(KN)
     * 时间复杂度O(KN^2)
     * @param K
     * @param N
     * @return
     */
    public int memoSolution(int K, int N) {
        int[][] memo = new int[K + 1][N + 1];
        for (int i = 1; i <= N; ++i) {
            // only one egg
            memo[1][i] = i;
        }
        for (int k = 2; k <= K; ++k) {
            for (int n = 1; n <= N; ++n) {
                int min = Integer.MAX_VALUE;
                for (int x = 1; x <= n; ++x) {
                    min = Math.min(min, 1 + Math.max(memoSolution(k - 1, x - 1), memoSolution(k, n - x)));
                }
                memo[k][n] = min;
            }
        }
        return memo[K][N];
    }


    private Map<Integer, Integer> cache = new HashMap<>();

    /**
     * 二分搜索求解
     * 时间复杂度: O(KNlog(N))
     * 空间复杂度：O(KN)
     * @param K
     * @param N
     * @return
     */
    public int binarySearchSolution(int K, int N) {
        if (N == 0) {
            return 0;
        }
        if (K == 1) {
            return N;
        }
        int cacheKey = K + 1000 * N;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        int low = 1, high = N;
        while (low + 1 < high) {
            int middle = (low + high) / 2;
            int lowVal = binarySearchSolution(K - 1, middle - 1);
            int highVal = binarySearchSolution(K, N - middle);
            if (lowVal < highVal) {
                low = middle;
            } else if (lowVal > highVal) {
                high = middle;
            } else {
                low = high = middle;
            }
        }
        int ret = 1 + Math.min(
                Math.max(binarySearchSolution(K - 1, low - 1), binarySearchSolution(K, N - low)),
                Math.max(binarySearchSolution(K - 1, high - 1), binarySearchSolution(K, N - high))
        );
        cache.put(cacheKey, ret);
        return ret;
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
        Assert.assertEquals(4, binarySearchSolution(3, 14));
        Assert.assertEquals(2, binarySearchSolution(1, 2));
        Assert.assertEquals(3, binarySearchSolution(2, 6));
    }

}
