package com.zhq.MediumProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/2
 */
public class Test29 {
    public static void main(String[] args) {
        int dividend = 7;
        int divisor = -3;
        System.out.println(divide(dividend, divisor));
    }

    /**
     * 有问题，未AC
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        // 特殊情况处理
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negativeFlag = false;
        if (dividend < 0) {
            negativeFlag = !negativeFlag;
        }
        if (divisor < 0) {
            negativeFlag = !negativeFlag;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int result = 0;
        if (dividend < divisor) {
            return result;
        }
        while (dividend >= divisor) {
            dividend -= divisor;
            result++;
        }
        if (negativeFlag) {
            result = -result;
        }
        return result;
    }

    /**
     * AC
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide2(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        while (dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while (dividend <= (temp_divisor << 1)) {
                if (temp_divisor <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }

        // 处理符号及整数溢出
        if (!sign) {
            if (result <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result = -result;
        }
        return result;
    }
}
