package com.zhq;

import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/3/4
 */
public class Interview52 {
    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }

        Stack<ListNode> aStack = new Stack<>();
        Stack<ListNode> bStack = new Stack<>();

        ListNode currentA = headA;
        while (currentA != null) {
            aStack.push(currentA);
            currentA = currentA.next;
        }

        ListNode currentB = headB;
        while (currentB != null) {
            bStack.push(currentB);
            currentB = currentB.next;
        }

        ListNode pre = null;
        while (!aStack.empty() && !bStack.empty()) {
            // no operation
            if (aStack.peek() == bStack.peek()) {
                pre = aStack.peek();
                aStack.pop();
                bStack.pop();
            } else {
                break;
            }
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode c3 = new ListNode(23, null);
        ListNode c2 = new ListNode(22, c3);
        ListNode c1 = new ListNode(21, c2);

        ListNode b3 = new ListNode(13, c1);
        ListNode b2 = new ListNode(12, b3);
        ListNode b1 = new ListNode(11, b2);

        ListNode a2 = new ListNode(2, c1);
        ListNode a1 = new ListNode(1, a2);


        ListNode intersectionNode = getIntersectionNode(a1, b1);
        System.out.println(intersectionNode.val);



    }

}
