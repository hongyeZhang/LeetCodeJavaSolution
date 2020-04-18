package com.zhq.HardProblem;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : ZHQ
 * @date : 2020/4/15
 */
public class Test25_3 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void printNodeList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
    }

    /**
     *
     * 通过栈来实现
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) {
            return head;
        }

        Deque<ListNode> stack = new LinkedList<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true) {
            int count = 0;
            ListNode current = head;
            while (current != null && count < k) {
                stack.push(current);
                current = current.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }

            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }
            p.next = current;
            head = current;
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println("before : " );
        printNodeList(node1);

        System.out.println();
        System.out.println("after : ");
        ListNode listNode = reverseKGroup(node1, 3);
        printNodeList(listNode);

    }








}
