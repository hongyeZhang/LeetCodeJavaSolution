package com.zhq.SimpleProblem;

import com.zhq.common.ListNode;
import com.zhq.util.ListNodeUtils;
import org.junit.Test;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/10/16 11:43
 */
public class Test83 {

    /**
     * 快慢指针的方式
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow = slow.next;
                slow.val = fast.val;
            }
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 2};
        ListNode listNode = ListNodeUtils.constructList(nums);
        ListNode head = deleteDuplicates(listNode);
        ListNodeUtils.printSingleList(head);
    }

}
