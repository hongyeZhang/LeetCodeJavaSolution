package com.zhq.SimpleProblem;

import com.zhq.util.PrintUtils;
import org.junit.Test;

/**
 * @program: LeetCodeTest
 * @description: 删除排序数组中的重复项
 * @author: ZHQ
 * @create: 2019-06-01 16:30
 **/
public class Test26 {

    @Test
    public void test() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        System.out.println(len);
        PrintUtils.printArray(nums);
    }

    /**
    * @Description: ZHQ
    * @Param:
    * @return:
    * @Author: ZHQ
    * @Date: 2019/6/1
    **/
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[len]) {
                continue;
            } else {
                len++;
                nums[len] = nums[i];
            }
        }
        return len + 1;
    }

/*     数组完成排序后，我们可以放置两个指针 iii 和 jjj，其中 iii 是慢指针，而 jjj 是快指针。
     只要 nums[i]=nums[j]nums[i] = nums[j]nums[i]=nums[j]，我们就增加 jjj 以跳过重复项。

    当我们遇到 nums[j]≠nums[i]nums[j] \neq nums[i]nums[j]​=nums[i] 时，
     跳过重复项的运行已经结束，因此我们必须把它（nums[j]nums[j]nums[j]）的值复制到
     nums[i+1]nums[i + 1]nums[i+1]。然后递增 iii，接着我们将再次重复相同的过程，直到 jjj 到达数组的末尾为止。*/


/**
* @Description: 官方题解
* @Param:
* @return:
* @Author: ZHQ
* @Date: 2019/6/1
**/
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0){ return 0;}
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 双指针：快慢指针
     * @param nums
     * @return
     */
    public int removeDuplicates3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currentIndex = 0, fastIndex = 0;
        int res = 1;
        for (int i = 0; i < nums.length; ++i) {
            while (fastIndex < nums.length && nums[fastIndex] <= nums[currentIndex]) {
                fastIndex++;
            }
            if (fastIndex < nums.length) {
                currentIndex++;
                swap(nums, currentIndex, fastIndex);
                res++;
            }
        }
        return res;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int removeDuplicates4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }



}
