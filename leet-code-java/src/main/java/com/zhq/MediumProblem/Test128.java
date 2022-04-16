package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/4/10 16:00
 */
public class Test128 {

    /**
     * 对于一个数 num， 如果数组中存在 num-1，则跳过。只有当数组中没有num的前驱节点时，才开始统计以num为开头的连续递增的序列的长度。
     * 时间复杂度： O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLen = 0;
        for (Integer num : numSet) {
            if (numSet.contains(num - 1)) {
                continue;
            }
            int currentNum = num;
            int currentLen = 1;
            while (numSet.contains(currentNum + 1)) {
                currentNum += 1;
                currentLen += 1;
            }
            maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }


    /**
     * hash 表，通过端点来进行判断。
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        return 0;
    }

    @Test
    public void test() {
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }


}
