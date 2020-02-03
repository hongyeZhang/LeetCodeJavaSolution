package com.zhq.HardProblem;

import java.util.Arrays;

/**
 * @author : ZHQ
 * @date : 2020/2/3
 */
public class Test41_2 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 0};
//        int[] nums = {3, 4, -1, 1};
//        int[] nums = {7, 8, 9, 11, 12};
        int[] nums = {0, 2, 2, 1, 1};
        System.out.println(firstMissingPositive(nums));


    }

    /**
     * 时间复杂度不符合要求
     * 未通过全部测试用例，太繁琐
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        Arrays.sort(nums);
        if (nums[0] > 1) {
            return 1;
        } else {
            if (nums[0] <= 0) {
                int i = 0;
                while (i < nums.length && nums[i] <= 0) {
                    i++;
                }
                if (i == nums.length) {
                    return 1;
                } else {
                    if (nums[i] > 1) {
                        return 1;
                    } else {
                        // 第一个正数是 1
                        int current = nums[i];
                        while (i < nums.length) {
                            if (nums[i] != current) {
                                return current;
                            }
                            while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                                i++;
                            }
                            i++;
                            current++;
                        }
                        if (i == nums.length) {
                            return nums[nums.length - 1] + 1;
                        }
                    }
                }
            } else {
                // 第一个数是1
                int j = 0;
                int current = nums[j];
                while (j < nums.length) {
                    if (nums[j] != current) {
                        return current;
                    }
                    j++;
                    current++;
                }
                if (j == nums.length) {
                    return nums[nums.length - 1] + 1;
                }
            }
        }

        return 1;
    }




}
