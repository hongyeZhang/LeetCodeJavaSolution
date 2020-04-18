package interview.practice;

import org.junit.Test;

/**
 * 与链表有关的算法练习
 *
 * @author : ZHQ
 * @date : 2020/4/11
 */
public class ListPracticeAlgorithm {
    static class ListNode {
        int val;

        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void printSingleList(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println(current.val);
    }


    /** 链表相加（逆序表示）
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersFromInverseList(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        } else if (null == l1 && null != l2) {
            return l2;
        } else if (null == l2 && null != l1) {
            return l1;
        }

        ListNode dummyNode = new ListNode(0);
        ListNode newHead = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = null == l1 ? 0 : l1.val;
            int num2 = null == l2 ? 0 : l2.val;
            int val = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;
            newHead.next = new ListNode(val);
            newHead = newHead.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            newHead.next = new ListNode(1);
        }

        return dummyNode.next;
    }

    @Test
    public void testAddTwoNumbersFromInverseList() {
//        ListNode node6 = new ListNode(6, null);
//        ListNode node1 = new ListNode(1, node6);
//        ListNode node7 = new ListNode(7, node1);
//        printSingleList(node7);
//        ListNode node3 = new ListNode(3, null);
//        ListNode node9 = new ListNode(9, node3);
//        ListNode node5 = new ListNode(5, node9);
//        printSingleList(node5);
//        printSingleList(addTwoNumbersFromInverseList(node7, node5));

        ListNode node8 = new ListNode(8, null);
        ListNode node1 = new ListNode(1, node8);
        printSingleList(node1);
        ListNode node0 = new ListNode(0, null);
        printSingleList(node0);
        printSingleList(addTwoNumbersFromInverseList(node1, node0));

    }


    /** 反转
     * @param head
     * @return
     */
    public ListNode inverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode current = head;
        ListNode pre = null;
        while (current.next != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        current.next = pre;
        return current;
    }

    public ListNode inverseList2(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    @Test
    public void testInverseList() {
        ListNode node8 = new ListNode(8, null);
        ListNode node1 = new ListNode(1, node8);
        printSingleList(node1);
        System.out.println("after inverse");
//        printSingleList(inverseList(node1));
        printSingleList(inverseList2(node1));
    }



    public void printKGroupList(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null) {
            for (int i = 0; i < k && current != null; ++i) {
                current = current.next;
                System.out.print(current.val + "\t");
            }
            System.out.println();
            System.out.println("over");
            break;
        }

    }

    @Test
    public void test() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        printKGroupList(node1, 7);






    }
















}
