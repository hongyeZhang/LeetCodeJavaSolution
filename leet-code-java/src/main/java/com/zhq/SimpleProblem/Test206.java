package com.zhq.SimpleProblem;

import com.zhq.common.ListNode;
import com.zhq.util.ListNodeUtils;
import org.junit.Test;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-07-02
 **/
public class Test206 {

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 3, 4};
        ListNode node1 = ListNodeUtils.constructList(nums1);
        ListNodeUtils.printSingleList(node1);
        ListNodeUtils.printSingleList(reverseList(node1));
    }

    /**
     * 链表反转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode post = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = post;
            post = curr;
            curr = nextNode;
        }
        return post;
    }

}
