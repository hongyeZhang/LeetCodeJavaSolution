package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-05-19 16:27
 **/
public class TempTest {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; ++i) {
            farthest = Math.max(i + nums[i], farthest);
            if (farthest == i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }


}
