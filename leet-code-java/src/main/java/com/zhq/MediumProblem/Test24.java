package com.zhq.MediumProblem;

import com.zhq.HardProblem.Test23;

/**
 * @author : ZHQ
 * @date : 2020/1/31
 */
public class Test24 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        printNodeList(node1);
        System.out.println();

        ListNode listNode = swapPairs(node1);
        printNodeList(listNode);

    }

    public static void printNodeList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
    }


    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(second.next);
        // 与上面一句的不能交换顺序，否则报错
        second.next = first;
        return second;
    }





}
