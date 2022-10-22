package algorithm.searching;

import org.junit.Assert;
import org.junit.Test;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-07-16
 **/
public class BinarySearch {

    @Test
    public void test() {
        int[] nums = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101};
        Assert.assertEquals(0, binSearch(nums, 0, nums.length - 1, 3));
        Assert.assertEquals(0, binSearch(nums, 3));
    }

    @Test
    public void testLeftBound() {
        int[] nums = new int[]{1, 2, 3, 3, 3, 5, 7};
        Assert.assertEquals(2, leftBound(nums, 3));

        // 边界case
        int[] nums2 = new int[]{3, 3, 3, 3, 4, 5, 6};
        Assert.assertEquals(-1, leftBound(nums2, 2));
        Assert.assertEquals(-1, leftBound(nums2, 7));
    }

    /**
     * 查找nums 中等于 target 的最左边的元素 index
     * 注意最后加一个语句处理未找到的情况！！！
     * @param nums
     * @param target
     * @return
     */
    public int leftBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // 边界case处理
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    @Test
    public void testRightBound() {
        int[] nums = new int[]{1, 2, 3, 3, 3, 5, 7};
        Assert.assertEquals(4, rightBound(nums, 3));

        // 边界case
        int[] nums2 = new int[]{3, 3, 3, 3, 4, 5, 6};
        Assert.assertEquals(-1, rightBound(nums2, 2));
        Assert.assertEquals(-1, rightBound(nums2, 7));
    }

    /**
     * 查找nums 中等于 target 的最右边的元素 index
     * @param nums
     * @param target
     * @return
     */
    public int rightBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // 边界case处理
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }


    /**
     * 二分查找1: 普通循环实现
     * @param a
     * @param key
     * @return
     */
    public int binSearch(int[] a, int key) {
        int mid = a.length / 2;
        if (key == a[mid]) {
            return mid;
        }
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key > a[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找递归实现
     * @param a
     * @param start
     * @param end
     * @param key
     * @return
     */
    public int binSearch(int[] a, int start, int end, int key) {
        int mid = start + (end - start) / 2;
        if (a[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > a[mid]) {
            return binSearch(a, mid + 1, end, key);
        } else if (key < a[mid]) {
            return binSearch(a, start, mid - 1, key);
        }
        return -1;
    }


}
