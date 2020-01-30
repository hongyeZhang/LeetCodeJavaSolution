package com.zhq.MediumProblem;

/**
 * @program: LeetCodeTest
 * @description: 下一个排列
 * @author: ZHQ
 * @create: 2019-06-01 16:48
 **/
public class Test31 {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        int[] nums = {1, 3, 2};
        int[] nums = {3, 2, 1};

        Test31 test31 = new Test31();
        test31.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }

    }


    /**
    * @Description: 官方解答
    先找出最大的索引 k 满足 nums[k] < nums[k+1]，如果不存在，就翻转整个数组；
    再找出另一个最大索引 l 满足 nums[l] > nums[k]；
    交换 nums[l] 和 nums[k]；
    最后翻转 nums[k+1:]。
     * @Param:
    * @return:
    * @Author: ZHQ
    * @Date: 2019/6/1
    **/
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
