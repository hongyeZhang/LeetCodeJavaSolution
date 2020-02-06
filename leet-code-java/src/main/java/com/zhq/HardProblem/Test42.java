package com.zhq.HardProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/4
 */
public class Test42 {
    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(heights));
        System.out.println(trapDynamic(heights));


    }

    /**
     * 官方题解： 直观解法
     * 直接按问题描述进行。对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
     * https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int ans = 0;
        int len = height.length;
        for (int i = 1; i < len - 1; ++i) {
            int maxLeftHeight = 0;
            int maxRightHeight = 0;
            // 左、右两部分分别寻找最大值
            // TODO: 2020/2/5   未理解这种做法的思想
            for (int j = i; j >= 0; --j) {
                maxLeftHeight = Math.max(maxLeftHeight, height[j]);
            }
            for (int j = i; j < len; ++j) {
                maxRightHeight = Math.max(maxRightHeight, height[j]);
            }
            ans += Math.min(maxLeftHeight, maxRightHeight) - height[i];
        }
        return ans;
    }


    /**
     * 动态计算，利用之前的计算结果
     * @param height
     * @return
     */
    public static int trapDynamic(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int ans = 0;
        int len = height.length;
        int[] leftMaxArray = new int[len];
        int[] rightMaxArray = new int[len];

        leftMaxArray[0] = height[0];
        for (int i = 1; i < len; ++i) {
            leftMaxArray[i] = Math.max(leftMaxArray[i - 1], height[i]);
        }
        rightMaxArray[len - 1] = height[len - 1];
        for (int j = len - 2; j >= 0; --j) {
            rightMaxArray[j] = Math.max(rightMaxArray[j + 1], height[j]);
        }
        for (int i = 0; i < len - 1; ++i) {
            ans += Math.min(leftMaxArray[i], rightMaxArray[i]) - height[i];
        }
        return ans;
    }


}
