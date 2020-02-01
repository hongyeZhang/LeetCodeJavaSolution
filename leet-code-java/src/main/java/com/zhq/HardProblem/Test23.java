package com.zhq.HardProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/1/31
 */
public class Test23 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
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

    public static void printNodeList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
    }


    /** 暴力求解，先将所有链表的数据存储到一个数组中，再对数组排序，根据排好序的数组构建一个新的链表
     *  时间复杂度 ： O(NlogN)
     *  空间复杂度 ： O(N)
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> valList = new ArrayList<>();
        for (ListNode head : lists) {
            while (head != null) {
                valList.add(head.val);
                head = head.next;
            }
        }
        Collections.sort(valList);
        if (valList.size() == 0) {
            return null;
        } else if (valList.size() == 1) {
            return new ListNode(valList.get(0));
        }
        ListNode head = new ListNode(valList.get(0));
        ListNode current = head;
        for (Integer integer : valList.subList(1,valList.size())) {
            current.next = new ListNode(integer);
            current = current.next;
        }

        return head;
    }



}
