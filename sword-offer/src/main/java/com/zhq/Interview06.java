package com.zhq;

import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/2/29
 */
public class Interview06 {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        int[] out = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            out[i++] = stack.pop();
        }

        return out;
    }

    /** 列表反转
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode post = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = post;
            post = current;
            current = nextNode;
        }
        return post;
    }



    public static void printLinkList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            if (current.next != null) {
                System.out.print(current.val + "->");
            } else {
                System.out.print(current.val);
            }
            current = current.next;
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

//        int[] ints = reversePrint(node1);
//        for (int anInt : ints) {
//            System.out.print(anInt + "\t");
//        }

        printLinkList(node1);
        System.out.println();

        printLinkList(reverseList(node1));







    }



}
