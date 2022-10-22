package utils;

import common.ListNode;
import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/16 11:49
 */
public final class ListNodeUtils {

    public static ListNode constructList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode current = new ListNode(nums[0]);
        ListNode head = current;
        for (int i = 1; i < nums.length; ++i) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }

    public static Integer extractNodeVal(ListNode node) {
        return node == null ? null : node.val;
    }

    public static void printNode(ListNode node) {
        if (node == null) {
            System.out.println("null");
        } else {
            System.out.println(node.val);
        }
    }

    public static void printSingleList(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println(current.val);
    }

    /**
     * 按顺序合并两个列表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else if (l2 != null) {
            p.next = l2;
        }
        return dummy.next;
    }


    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = constructList(nums);
        printSingleList(head);
    }

}
