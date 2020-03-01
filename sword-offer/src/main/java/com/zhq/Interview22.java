package com.zhq;

import sun.net.www.content.text.PlainTextInputStream;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class Interview22 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (null == head || k <= 0) {
            return head;
        }
        ListNode first = head, second = head;
        int i = 0;
        while (++i <= k && null != first) {
            first = first.next;
        }
        if (i == k + 1) {
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            return second;
        } else {
            return null;
        }
    }

    public static void printLinkList(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print(current.val);
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printLinkList(node1);
        System.out.println();
        printLinkList(getKthFromEnd(node1, 2));

    }





}
