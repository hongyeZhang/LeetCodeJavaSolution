package com.zhq.MediumProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class Test61 {

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
    }

    /**
     * 先将链表表示成一个数组，然后向右旋转数组，再将结果数组组装成链表返回
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }

        ListNode curr = head;
        // 确定链表的长度
        int listLen = 0;
        while (curr != null) {
            listLen++;
            curr = curr.next;
        }


        int[] inputArray = new int[listLen];
        curr = head;
        int index = 0;
        while (curr != null) {
            inputArray[index] = curr.val;
            curr = curr.next;
            index++;
        }

        k %= listLen;
        int[] newIntArray = rightRotateIntArray(inputArray, k);
        ListNode retHead = new ListNode(newIntArray[0]);
        ListNode retCurr = retHead;
        for (int i = 1; i < newIntArray.length; ++i) {
            retCurr.next = new ListNode(newIntArray[i]);
            retCurr = retCurr.next;
        }
        return retHead;
    }

    public static int[] rightRotateIntArray(int[] ints, int k) {
        int len = ints.length;
        int[] newArray = new int[len];
        System.arraycopy(ints, len - k, newArray, 0, k);
        System.arraycopy(ints, 0, newArray, k, len - k);
        return newArray;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(-1);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printList(node1);
        System.out.println();

        printList(rotateRight(node1, 13));

    }




}
