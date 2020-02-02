package com.zhq.SimpleProblem;

/**
 * @program: LeetCodeTest
 * @description: 删除排序数组中的重复项
 * @author: ZHQ
 * @create: 2019-06-01 16:30
 **/
public class Test26 {

    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + "\t");
        }

    }

    /**
    * @Description: ZHQ
    * @Param:
    * @return:
    * @Author: ZHQ
    * @Date: 2019/6/1
    **/
    public static int removeDuplicates(int[] nums) {
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
    public static int removeDuplicates2(int[] nums) {
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



}
