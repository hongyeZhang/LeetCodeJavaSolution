package interview.practice;

import common.ListNode;
import org.junit.Test;
import utils.ListNodeUtils;

import static utils.ListNodeUtils.printSingleList;

/**
 * 与链表有关的算法练习
 *
 * @author : ZHQ
 * @date : 2020/4/11
 */
public class ListPracticeAlgorithm {


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

    /**
     * 递归的方法翻转链表
     * 操作原理可以画图表示
     * @param head
     * @return
     */
    public ListNode inverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = inverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    @Test
    public void testInverseList() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode node1 = ListNodeUtils.constructList(nums);
        ListNodeUtils.printSingleList(node1);
        ListNode node2 = inverseList3(node1);
        ListNodeUtils.printSingleList(node2);
    }

    /**
     * 旋转链表的前n个节点，通过记录后驱节点来实现翻转
     * 假定 n 小于链表的长度
     *
     * @param head
     * @param n
     * @return
     */
    ListNode successor = null;
    public ListNode inverseFirstN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = inverseFirstN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    @Test
    public void testInverseNList() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode node1 = ListNodeUtils.constructList(nums);
        ListNodeUtils.printSingleList(node1);
        ListNode node2 = inverseFirstN(node1, 3);
        ListNodeUtils.printSingleList(node2);
    }

    /**
     * 翻转链表的第 m 到 n 个节点
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode inverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return inverseFirstN(head, n);
        }
        head.next = inverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    @Test
    public void testInverseBetween() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode node1 = ListNodeUtils.constructList(nums);
        ListNodeUtils.printSingleList(node1);
        ListNode node2 = inverseBetween(node1, 2, 3);
        ListNodeUtils.printSingleList(node2);
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
    public void testPrintKGroupList() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        printKGroupList(node1, 7);
    }


    @Test
    public void testGetKthFromEnd() {
        int[] nums = new int[]{1};
        ListNode head = ListNodeUtils.constructList(nums);
        ListNode kthFromEnd = getKthFromEnd(head, 1);
        ListNodeUtils.printNode(kthFromEnd);

        ListNode kthFromEnd2 = getKthFromEnd(head, 5);
        ListNodeUtils.printNode(kthFromEnd2);
    }


    /**
     * 获得链表的倒数第K个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode first = head, second = head;
        int i = 0;
        while (i < k && first != null) {
            first = first.next;
            i++;
        }
        if (i < k) {
            return null;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    /**
     * 快慢指针法寻找列表的中间节点
     * 如果链表的长度是偶数，次算法返回的是两个中间节点的第二个
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 判断链表是否有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 计算链表中环的起点
     * (1)判断是否有环
     * (2)两个指针相遇后，让两个指针分别从链表头和相遇点重新出发，每次走一步，最后一定相遇于环入口。 这里直接写结论，证明 STFW
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next.next;
            if (fast == slow) {
                break;
            }
        }

        // 如果快节点为null，说明走到了最后，链表中没有环
        if (fast == null || fast.next == null) {
            return null;
        }
        // 任意一个节点重新指向头节点
        slow = head;
        while (slow != fast) {
            // 快慢指针同步前进，相交点就是环的起点
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 求两个链表的相交节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
















}
