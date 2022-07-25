package com.zhq.MediumProblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ZHQ
 * @date 2022/7/23
 */
public class Test494 {

    HashMap<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return dp(nums, 0, target);
    }

    int dp(int[] nums, int i, int remain) {
        if (i == nums.length) {
            if (remain == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        String key = i + "," + remain;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = dp(nums, i + 1, remain + nums[i]) + dp(nums, i + 1, remain - nums[i]);
        memo.put(key, res);
        return res;
    }


    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        Assert.assertEquals(5, findTargetSumWays(nums, target));
    }

}
