package com.zhq.SimpleProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: LeetCodeTest
 * @description: 整数反转
 * @author: ZHQ
 * @create: 2019-05-19 22:13
 **/
public class Test7 {

    public static void main(String[] args) {

        int a = -2147483648;
        System.out.println(reverseZHQ(a));

    }

    /**
    * @Description: integer边界情况的转换
    * @Param:
    * @return:
    * @Author: ZHQ
    * @Date: 2019/5/19
    **/
    public static int reverseZHQ(int x) {
        long tempX = x;
        if (tempX == 0) {
            return (int) tempX;
        }

        boolean isNegative = false;
        if (tempX < 0) {
            isNegative = true;
            tempX = -tempX;
        }

        List<String> tempList = new ArrayList<>();
        while (tempX != 0) {
            long a = tempX % 10;
            tempX = tempX / 10;
            tempList.add(String.valueOf(a));
        }
        StringBuilder ret = new StringBuilder();
        for (String s : tempList) {
            ret.append(s);
        }
        long result = Long.valueOf(ret.toString());
        if (result > Integer.MAX_VALUE) {
            result = 0;
        } else{
            if (isNegative) {
                result = -result;
            }
        }

        return (int) result;
    }


    /**
    * @Description:  官方解答
    * @Param:
    * @return:
    * @Author: ZHQ
    * @Date: 2019/5/20
    **/
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }




}
