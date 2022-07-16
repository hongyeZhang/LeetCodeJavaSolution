package com.zhq.HardProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/4/19 09:51
 */
public class Test312 {

    /**
     * 动态规划问题：状态方程比较难写
     * https://mp.weixin.qq.com/s/I0yo0XZamm-jMpG-_B3G8g
     * dp[i][j] 代表戳破 i 和 j 之间的数组，能够获得的最大分数
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // 重新生成一个数组
        int[] nums2 = new int[n + 2];
        nums2[0] = 1;
        nums2[n + 1] = 1;
        for (int i = 1; i < n + 1; ++i) {
            nums2[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int i = n + 1; i >= 0; --i) {
            for (int j = i + 1; j <= n + 1; ++j) {
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], nums2[k] * nums2[i] * nums2[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n + 1];
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 5};
        System.out.println(maxCoins(nums));
    }


}
