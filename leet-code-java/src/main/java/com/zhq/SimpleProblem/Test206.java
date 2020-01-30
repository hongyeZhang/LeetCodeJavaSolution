package com.zhq.SimpleProblem;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-07-02
 **/
public class Test206 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        printListNode(node1);
        printListNode(reverseList(node1));


    }

    public static ListNode reverseList(ListNode head) {
        ListNode post = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = post;
            post = curr;
            curr = nextNode;
        }

        return post;
    }

    public static void printListNode(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }



}
