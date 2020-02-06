package com.zhq.SimpleProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/5
 */
public class Test415 {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(addStrings(num1, num2));

    }

    /** 通俗易懂
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
