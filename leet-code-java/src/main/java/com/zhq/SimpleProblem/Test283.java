package com.zhq.SimpleProblem;

import com.zhq.util.PrintUtils;
import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/16 16:50
 */
public class Test283 {

    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        PrintUtils.printArray(nums);
    }


    /**
     * 快慢指针
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }


}
