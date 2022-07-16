package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/4/22 09:14
 */
public class Test494_2 {

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<String, Integer> memo = new HashMap<>();
        return dp(nums, 0, target, memo);
    }

    public int dp(int[] nums, int index, int remain, Map<String, Integer> memo) {
        if (index == nums.length) {
            if (remain == 0) {
                return 1;
            }
            return 0;
        }
        String key = index + "-" + remain;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = dp(nums, index + 1, remain - nums[index], memo)
                + dp(nums, index + 1, remain + nums[index], memo);

        memo.put(key, res);
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1};
        System.out.println(findTargetSumWays(nums, 1));
    }



}
