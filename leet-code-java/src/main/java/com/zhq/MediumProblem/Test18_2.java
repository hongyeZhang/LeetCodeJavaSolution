package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test18_2 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> retList = new ArrayList<>();
        if (null == nums || nums.length < 4) {
            return retList;
        }
        int len = nums.length;
        Arrays.sort(nums);

        for (int first = 0; first < len - 3; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < len - 2; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = second + 1;
                int fourth = len - 1;
                while (third < fourth) {
                    int currentSum = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (currentSum == target) {
                        retList.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        while (third < fourth && nums[third] == nums[third + 1]) {
                            third++;
                        }
                        while (third < fourth && nums[fourth] == nums[fourth - 1]) {
                            fourth--;
                        }
                        third++;
                        fourth--;
                    } else if (currentSum > target) {
                        fourth--;
                    } else {
                        third++;
                    }
                }
            }
        }

        return retList;
    }

    @Test
    public void test() {
        int[] nums = new int[] {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSum(nums, 0);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }




    }

}
