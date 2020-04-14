package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test11_2 {

    /**
     * 双指针对撞法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (null == height || height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, (Math.min(height[left], height[right]) * (right - left)));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    @Test
    public void test() {
        int[] nums = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
    }
}
