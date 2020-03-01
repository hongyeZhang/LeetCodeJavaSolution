package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class Interview16 {

    public static double myPow(double x, int n) {
        return calculatePow(x, n);
    }

    /**
     * @param base
     * @param exponent 定义为long类型是为了解决 exponent 为 Integer.MIN_VALUE 类型时 取反造成的溢出
     * @return
     */
    public static double calculatePow(double base, long exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }

        if (exponent < 0) {
            base = 1 / base;
            exponent *= -1;
        }
        double result = calculatePow(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            // 奇数
            result *= base;
        }
        return result;
    }


    public static void main(String[] args) {

        System.out.println(myPow(2, -3));
        System.out.println(Integer.MIN_VALUE);

    }
}
