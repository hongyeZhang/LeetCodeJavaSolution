package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/6
 */
public class Interview65 {

    public static int add(int a, int b) {
        int sum, carry;
        while (b != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return a;
    }


    public static void main(String[] args) {

        System.out.println(add(5,7));

    }


}
