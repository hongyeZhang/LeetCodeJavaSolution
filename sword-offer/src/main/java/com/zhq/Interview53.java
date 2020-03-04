package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/4
 */
public class Interview53 {

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

        int index = binarySearch(nums, target, 0, nums.length - 1);
        if (index == -1) {
            return 0;
        }

        int startIndex = index;
        int endIndex = index;
        while (startIndex>=0 && nums[startIndex] == target) {
            startIndex--;
        }
        startIndex++;

        while (endIndex < nums.length && nums[endIndex] == target) {
            endIndex++;
        }
        endIndex--;

        return endIndex - startIndex + 1;
    }

    private static int binarySearch(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int mid = startIndex + (endIndex - startIndex) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, endIndex);
        } else {
            return binarySearch(nums, target, startIndex, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 2};
//        int[] nums = new int[] {5, 7, 7, 8, 8, 10};
//        int[] nums = new int[] {5, 6, 7, 8, 9, 10};

//        System.out.println(search(nums, 8));
        System.out.println(search(nums, 2));




    }


}
