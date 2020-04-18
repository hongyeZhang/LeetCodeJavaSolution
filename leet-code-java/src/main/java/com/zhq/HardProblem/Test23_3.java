package com.zhq.HardProblem;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : ZHQ
 * @date : 2020/4/16
 */
public class Test23_3 {

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

    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }

        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };

        PriorityQueue<ListNode> queue = new PriorityQueue<>(comparator);
        for (int i = 0; i < lists.length; ++i) {
            while (lists[i] != null) {
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while (!queue.isEmpty()) {
            ListNode tmpNode = queue.poll();
            // 如果不加这句，会造成循环
            tmpNode.next = null;
            current.next = tmpNode;
            current = current.next;
        }

        return dummyNode.next;
    }

    @Test
    public void test() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;

        ListNode[] inputArr = new ListNode[3];
        inputArr[0] = node1;
        inputArr[1] = node4;
        inputArr[2] = node7;

        ListNode node = mergeKLists(inputArr);
        printNodeList(node);

    }








}
