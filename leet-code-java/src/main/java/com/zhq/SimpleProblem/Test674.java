package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * 最长连续递增序列的长度
 * @author : ZHQ
 * @date : 2020/4/4
 */
public class Test674 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }

        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; ++i) {
            dp[i] = 1;
        }

        for (int i = 1; i < len; ++i) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int ret = dp[0];
        for (int i : dp) {
            ret = Math.max(i, ret);
        }

        return ret;
    }


    @Test
    public void test() {
        int[] nums1 = new int[] {1, 3, 5, 4, 7};
        int[] nums2 = new int[] {2, 2, 2, 2, 2};

        System.out.println(findLengthOfLCIS(nums1));
        System.out.println(findLengthOfLCIS(nums2));

    }




}
