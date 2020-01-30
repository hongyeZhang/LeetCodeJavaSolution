package com.zhq.MediumProblem;

/**
 * @program: LeetCodeTest
 * @description: 盛水最多的容器
 * @author: ZHQ
 * @create: 2019-05-25 18:59
 **/
public class Test11 {

    public static void main(String[] args) {

        int[] intput = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(intput));
        System.out.println(maxArea2(intput));

    }

    /**
     * @Description: 简单粗暴
     * @Param: [height]
     * @return: int
     * @Author: ZHQ
     * @Date: 2019/5/25
     **/
    public static int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                int minHeight = Math.min(height[i], height[j]);
                int tempArea = minHeight * (j - i);
                if (tempArea > maxArea) {
                    maxArea = tempArea;
                }
            }
        }
        return maxArea;
    }

    /**
     * @Description: 双指针法，两个指针在数组的头和尾，一起向中间移动
     * @Param: [height]
     * @return: int
     * @Author: ZHQ
     * @Date: 2019/5/25
     **/
    public static int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int currentArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentArea);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
