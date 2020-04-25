package com.zhq;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : ZHQ
 * @date : 2020/4/19
 */
public class Interview45 {

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        int len = nums.length;
        String[] strNums = new String[len];
        for (int i = 0; i < len; ++i) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        };

        Arrays.sort(strNums, comparator);
        StringBuilder sb = new StringBuilder("");
        for (String strNum : strNums) {
            sb.append(strNum);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        int[] nums = new int[] {3, 30, 34, 5, 9};
        System.out.println(minNumber(nums));

    }






}
