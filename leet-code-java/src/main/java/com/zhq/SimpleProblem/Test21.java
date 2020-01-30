package com.zhq.SimpleProblem;


/**
 * @program: LeetCodeTest
 * @description: 合并两个有序链表
 * @author: ZHQ
 * @create: 2019-07-02
 **/
public class Test21 {
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
        printListNode(node1);
        System.out.println();

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        printListNode(node4);
        System.out.println();

        printListNode(mergeTwoLists(node1, node4));


    }


    /**
    * @Description:  AC
    * @Param:
    * @return:
    * @Author: ZHQ
    * @Date: 2019-07-02
    */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode head = ret;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }

        return ret.next;
    }

    public static void printListNode(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }




}
