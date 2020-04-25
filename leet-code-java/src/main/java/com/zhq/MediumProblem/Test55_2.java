package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/24
 */
public class Test55_2 {

    public boolean canJump(int[] nums) {
        boolean jumpFlag = false;
        if (nums == null || nums.length < 1) {
            return jumpFlag;
        }

        int position = nums.length - 1;
        int whileIndex = 0;
        while (position != 0) {
            if (whileIndex >= nums.length) {
                break;
            }
            for (int i = 0; i < position; ++i) {
                if (nums[i] >= position - i) {
                    position = i;
                    break;
                }
            }
            whileIndex++;
        }
        if (position == 0) {
            jumpFlag = true;
        }
        return jumpFlag;
    }

    @Test
    public void test() {
        int[] nums = new int[] {2, 3, 1, 1, 4};

        System.out.println(canJump(nums));




    }



}
