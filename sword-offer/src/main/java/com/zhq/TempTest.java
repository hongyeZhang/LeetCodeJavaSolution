package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class TempTest {
    public static void main(String[] args) {


        int[] nums = new int[] {1, 1, 2, 3, 2, 3, 4};
        int ret = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            ret ^= nums[i];
        }
        System.out.println(ret);




    }



}
