package com.zhq.HardProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/5
 */
public class Test45 {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {8, 1, 1, 1, 1, 1, 4};
        System.out.println(jump(nums));

    }

    /**
     * 贪婪算法，仔细体会
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                // 遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 最终要到达最后一个位置，然后我们找前一个位置，遍历数组，找到能到达它的位置，离它最远的就是要找的位置。
     * 然后继续找上上个位置，最后到了第 0 个位置就结束了。
     * @param nums
     * @return
     */
    public int jumpSecondMethod(int[] nums) {
        // 要找的位置
        int position = nums.length - 1;
        int steps = 0;
        while (position != 0) {
            // 是否到了第 0 个位置
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    // 更新要找的位置
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }


}
