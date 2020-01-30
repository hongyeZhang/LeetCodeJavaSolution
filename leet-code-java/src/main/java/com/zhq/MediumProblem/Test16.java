package com.zhq.MediumProblem;

import java.util.Arrays;

/**
 * @program: LeetCodeTest
 * @description: 最接近的三数之和
 * @author: ZHQ
 * @create: 2019-05-27 22:20
 **/
public class Test16 {
    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        int targrt = 1;
        System.out.println(threeSumClosest(nums, targrt));

    }


    /**
    * @Description: 对撞指针，AC
    * @Param:
    * @return:
    * @Author: ZHQ
    * @Date: 2019/6/1
    **/
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int sum = nums[0] + nums[1] + nums[len - 1];

        for (int i = 0; i < len - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int tempSum = nums[i] + nums[left] + nums[right];
                if (tempSum == target){ return target;}
                if (Math.abs(tempSum - target) < Math.abs(sum - target)){ sum = tempSum;}
                if (tempSum > target){ right--;}
                if (tempSum < target){ left++;}
            }
        }
        return sum;
    }

}
