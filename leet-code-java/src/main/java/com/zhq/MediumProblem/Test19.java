package com.zhq.MediumProblem;

import java.time.Period;

/**
 * @author : ZHQ
 * @date : 2020/1/30
 */
public class Test19 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printList(head);
        System.out.println();

        removeNthFromEnd(head, 2);
        System.out.println("after delete");
        printList(head);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
    }


    /** 两个指针，间隔为N，第一个指针为空时，第二个指针就是要删除的位置，注意边界值的判断，当删除的
     *  节点刚好是头结点的时候，需要特殊处理
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        ListNode preSecond = head;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            preSecond = second;
            second = second.next;
        }

        if (second == head) {
            return head.next;
        } else {
            preSecond.next = second.next;
        }
        return head;
    }


}
