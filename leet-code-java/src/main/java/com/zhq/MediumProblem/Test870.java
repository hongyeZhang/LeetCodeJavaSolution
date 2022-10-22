package com.zhq.MediumProblem;

import com.zhq.util.PrintUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/15 23:01
 */
public class Test870 {


    @Test
    public void test() {
        int[] nums1 = new int[]{2, 7, 11, 15};
        int[] nums2 = new int[]{1, 10, 4, 11};
        int[] ints = advantageCount(nums1, nums2);
        PrintUtils.printArray(ints);
    }


    /**
     * 利用田忌赛马的思路，采用双指针的方式找出结果
     * 很巧妙的解决方式
     * 时间复杂度 O(nlogn)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        PriorityQueue<int[]> maxPq = new PriorityQueue<>((int[] pair1, int[] pair2) -> pair2[1] - pair1[1]);
        for (int i = 0; i < n; ++i) {
            maxPq.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);

        int[] res = new int[n];
        int left = 0, right = n - 1;
        while (!maxPq.isEmpty()) {
            int[] poll = maxPq.poll();
            int index = poll[0];
            if (nums1[right] > poll[1]) {
                res[index] = nums1[right];
                right--;
            } else {
                res[index] = nums1[left];
                left++;
            }
        }
        return res;
    }


    /**
     * 全排列的暴力解法
     * 超出了内存限制
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCountSecond(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return null;
        }

        int maxIndex = 0, maxAdvantage = 0;
        List<List<Integer>> allNums1 = fullPermutation(nums1);

        for (int index = 0; index < allNums1.size(); ++index) {
            int tmpAdvantage = 0;
            List<Integer> tmpList = allNums1.get(index);
            for (int i = 0; i < tmpList.size(); ++i) {
                if (tmpList.get(i) > nums2[i]) {
                    tmpAdvantage++;
                }
            }
            if (tmpAdvantage > maxAdvantage) {
                maxAdvantage = tmpAdvantage;
                maxIndex = index;
            }
        }

        List<Integer> retList = allNums1.get(maxIndex);
        int[] retArr = new int[retList.size()];
        for (int i = 0; i < retList.size(); ++i) {
            retArr[i] = retList.get(i);
        }
        return retArr;
    }

    public List<List<Integer>> fullPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> retList = new ArrayList<>();
        fullPermutationCore(nums, 0, retList);
        return retList;
    }

    public void fullPermutationCore(int[] nums, int index, List<List<Integer>> retList) {
        if (index == nums.length - 1) {
            List<Integer> tmpList = new ArrayList<>();
            for (int num : nums) {
                tmpList.add(num);
            }
            retList.add(tmpList);
        } else {
            for (int i = index; i < nums.length; ++i) {
                swap(nums, index, i);
                fullPermutationCore(nums, index + 1, retList);
                swap(nums, index, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
