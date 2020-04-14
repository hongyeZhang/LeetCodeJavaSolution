package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test15_2 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        if (null == nums || nums.length < 3) {
            return retList;
        }

        Arrays.sort(nums);
        int len = nums.length;
        for (int first = 0; first < len - 2; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = len - 1;
            while (second < third) {
                int currentSum = nums[first] + nums[second] + nums[third];
                if (currentSum == 0) {
                    retList.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    while (second < third && nums[second] == nums[second + 1]) {
                        second++;
                    }
                    while (second < third && nums[third] == nums[third - 1]) {
                        third--;
                    }
                    second++;
                    third--;
                } else if (currentSum > 0) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return retList;
    }

    @Test
    public void test() {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }




    }



}
