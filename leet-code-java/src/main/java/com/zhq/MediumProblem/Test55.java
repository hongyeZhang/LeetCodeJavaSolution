package com.zhq.MediumProblem;

import java.sql.PseudoColumnUsage;

/**
 * @author : ZHQ
 * @date : 2020/2/8
 */
public class Test55 {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3, 2, 1, 0, 4};
        int[] nums = {1, 1, 2, 2, 0, 1, 1};
        System.out.println(canJump(nums));


    }

    /**
     * 从目标位置向第一个位置逼近，与45题的降低难度版
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        boolean canJumpFlag = false;
        int position = nums.length - 1;
        int whileIndex = 0;
        while (position != 0) {
            if (whileIndex > nums.length) {
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
            canJumpFlag = true;
        }

        return canJumpFlag;
    }


}
