package com.zhq;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/3/6
 */
public class Interview62 {

    /** 模拟循环链表超时
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            list.add(i);
        }

        int removeIndex = 0;
        while (list.size() > 1) {
            removeIndex = (removeIndex + m - 1) % list.size();
            list.remove(removeIndex);
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5,3));
        System.out.println(lastRemaining(10,17));

    }

}
