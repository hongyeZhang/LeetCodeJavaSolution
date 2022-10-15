package com.zhq.util;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/8 13:11
 */
public class DifferenceArrayTest {

    @Test
    public void testConstruct() {
        int[] nums = new int[]{1, 3, 5, 7, 9};
        DifferenceArray differenceArray = new DifferenceArray(nums);
        differenceArray.printDifferenceArray();
    }
}
