package com.zhq.MediumProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/5
 */
public class Test43 {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));

    }

    /** 竖式乘法
     * 参考：https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String res = "0";

        for (int j = num2.length() - 1; j >= 0; --j) {
            StringBuilder tmp = new StringBuilder();
            for (int i = j; i < num2.length() - 1; ++i) {
                tmp.append('0');
            }
            int carry = 0;
            for (int i = num1.length() - 1; i >= 0 || carry != 0; --i) {
                int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int c = (n1 * n2 + carry) % 10;
                tmp.append(c);
                carry = (n1 * n2 + carry) / 10;
            }
            res = addStrings(res, tmp.reverse().toString());
        }

        return res;
    }

    /** 对两个字符串数字进行相加，返回字符串形式的和
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; --i, --j) {
            int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int n2 = j < 0 ? 0 : num2.charAt(j) - '0';
            int c = (n1 + n2 + carry) % 10;
            res.append(c);
            carry = (n1 + n2 + carry) / 10;
        }
        return res.reverse().toString();
    }

}
