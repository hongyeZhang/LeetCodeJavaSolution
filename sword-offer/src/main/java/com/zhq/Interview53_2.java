package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/4
 */
public class Interview53_2 {
    public static int search(int[] nums, int target) {
        if (null == nums) {
            return 0;
        } else if (nums.length == 1) {
            if (nums[0] == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int firstIndex = findFirstTarget(nums, target, 0, nums.length - 1);
        int lastIndex = findLastTarget(nums, target, 0, nums.length - 1);
        if (firstIndex > -1 && lastIndex > -1) {
            return lastIndex - firstIndex + 1;
        }
        return 0;
    }

    /** 二分法查找第一个出现的字符
     * @param nums
     * @param target
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int findFirstTarget(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int mid = startIndex + (endIndex - startIndex) / 2;
        int current = nums[mid];
        if (current == target) {
            int pre = mid - 1;
            if (pre >= 0 && nums[pre] == target) {
                return findFirstTarget(nums, target, startIndex, pre);
            }
            return mid;
        } else if (current > target) {
            return findFirstTarget(nums, target, startIndex, mid - 1);
        } else {
            return findFirstTarget(nums, target, mid + 1, endIndex);
        }
    }

    public static int findLastTarget(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int mid = startIndex + (endIndex - startIndex) / 2;
        int current = nums[mid];
        if (current == target) {
            int post = mid + 1;
            if (post < nums.length && nums[post] == target) {
                return findLastTarget(nums, target, post, endIndex);
            }
            return mid;
        } else if (current > target) {
            return findLastTarget(nums, target, startIndex, mid - 1);
        } else {
            return findLastTarget(nums, target, mid + 1, endIndex);
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {2, 2};
                int[] nums = new int[] {5, 7, 7, 8, 8, 10};
        //        int[] nums = new int[] {5, 6, 7, 8, 9, 10};

        //        System.out.println(search(nums, 8));
        System.out.println(search(nums, 8));
    }






}
