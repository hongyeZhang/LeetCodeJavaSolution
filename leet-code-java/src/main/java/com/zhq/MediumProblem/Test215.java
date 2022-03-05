package com.zhq.MediumProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/23 09:15
 */
public class Test215 {

    /**
     * 第K大的数字
     * 利用快速排序的思想进行快速选择
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int targetIndex = nums.length - k;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int partition = partition(nums, l, r);
            if (partition == targetIndex) {
                return nums[partition];
            } else if (partition < targetIndex) {
                l = partition + 1;
            } else {
                r = partition - 1;
            }
        }
        return -1;
    }

    public int partition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }


    @Test
    public void test() {
        int[] nums = new int[]{1};
        int kthLargest = findKthLargest(nums, 1);
        System.out.println(kthLargest);
    }

}
