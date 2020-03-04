package com.zhq;

import java.util.Arrays;

/**
 * @author : ZHQ
 * @date : 2020/3/3
 */
public class Interview42 {

    public static int maxSubArray2(int[] nums) {
        int ans = Integer.MIN_VALUE, sum = 0;
        for(int num : nums) {
            sum = Math.max(sum + num, num);
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    /** 动态规划
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {
        if (null == nums) {
            return 0;
        }

        int[] maxArr = new int[nums.length];
        maxArr[0] = nums[0];
        int max = maxArr[0];
        for (int i = 1; i < nums.length; ++i) {
            maxArr[i] = Math.max(nums[i], nums[i] + maxArr[i - 1]);
            max = Math.max(max, maxArr[i]);
        }
        return max;
    }



    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-2};

        System.out.println(maxSubArray2(nums));
        System.out.println(maxSubArray3(nums));
    }
}
