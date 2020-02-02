package com.zhq.SimpleProblem;

/**
 * @program: LeetCodeTest
 * @description: 移除元素
 * @author: ZHQ
 * @create: 2019-06-01 16:41
 **/
public class Test27 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int len = removeElement(nums, 2);
        for (int i = 0; i < len; ++i) {
            System.out.print(nums[i] + "\t");
        }
    }

    /**
    * @Description: ZHQ
    * @Param: 
    * @return: 
    * @Author: ZHQ
    * @Date: 2019/6/1
    **/ 
    public static int removeElement(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == val) {
                continue;
            }
            nums[len] = nums[i];
            len++;
        }

        return len;
    }
}
