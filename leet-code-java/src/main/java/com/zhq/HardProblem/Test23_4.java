package com.zhq.HardProblem;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author : ZHQ
 * @date : 2020/4/16
 */
public class Test23_4 {

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
        } else if (lists.length == 1) {
            return lists[0];
        }

        int k = lists.length;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(k, (o1, o2) -> (o1.val - o2.val));
        for (int i = 0; i < k; ++i) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while (!minHeap.isEmpty()) {
            ListNode tmpNode = minHeap.poll();
            current.next = tmpNode;
            current = current.next;
            if (tmpNode.next != null) {
                minHeap.add(tmpNode.next);
            }
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
