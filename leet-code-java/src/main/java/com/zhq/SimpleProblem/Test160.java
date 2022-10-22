package com.zhq.SimpleProblem;

import com.zhq.common.ListNode;
import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/18 12:56
 */
public class Test160 {

    @Test
    public void test() {

    }


    /**
     * 求两个链表的相交节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

}
