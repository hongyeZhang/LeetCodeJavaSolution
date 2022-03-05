package com.zhq.SimpleProblem;

import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/20 10:05
 */
public class Test69 {


    /**
     * 二分查找算法
     * 为了防止 int 越界，使用 long 来存储相乘的结果
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }


    @Test
    public void test() {
        int i = mySqrt(2147395599);
        System.out.println(i);
    }



}
