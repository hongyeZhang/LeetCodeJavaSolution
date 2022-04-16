package com.zhq.MediumProblem;


import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/2/8
 */
public class Test55 {

    /**
     * 从目标位置向第一个位置逼近，与45题的降低难度版
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
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

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        // 能跳到的最远的位置
        int farthest = 0;
        for (int i = 0; i < n - 1; ++i) {
            farthest = Math.max(i + nums[i], farthest);
            if (farthest == i) {
                // 可能是遇到了0，跳不过去了
                return false;
            }
        }
        return farthest >= n - 1;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 2, 2, 0, 1, 1};
        System.out.println(canJump(nums));
    }


}
