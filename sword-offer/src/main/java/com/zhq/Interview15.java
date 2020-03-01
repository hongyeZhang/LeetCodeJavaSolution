package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class Interview15 {

    /** 正数有效，负数无效
     * @param n
     * @return
     */
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    /** 正负数无限制
     * @param n
     * @return
     */
    public static int hammingWeight2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int hammingWeight3(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = n & (n - 1);
        }
        return count;
    }






    public static void main(String[] args) {
        System.out.println(hammingWeight2(9));
        System.out.println(hammingWeight3(9));

    }
}
