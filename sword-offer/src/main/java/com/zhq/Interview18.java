package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class Interview18 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode current = head;
        ListNode pre = null;

        // 头结点
        if (head.val == val) {
            return head.next;
        }

        // 非头结点
        pre = current;
        current = current.next;
        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
                break;
            }
            pre = current;
            current = current.next;
        }

        return head;
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
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        printLinkList(node1);
        System.out.println();

//        printLinkList(deleteNode(node1, 4));
//        printLinkList(deleteNode(node1, 9));
//        printLinkList(deleteNode(node1, 1));






    }





}
