package com.zhq.MediumProblem;

import com.zhq.common.ListNode;
import com.zhq.util.ListNodeUtils;
import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/1/30
 */
public class Test19 {

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNodeUtils.constructList(nums);
        ListNodeUtils.printSingleList(head);
        removeNthFromEnd(head, 2);
        ListNodeUtils.printSingleList(head);
    }

    /**
     * 两个指针，间隔为N，第一个指针为空时，第二个指针就是要删除的位置，注意边界值的判断，当删除的
     * 节点刚好是头结点的时候，需要特殊处理
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        ListNode preSecond = head;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            preSecond = second;
            second = second.next;
        }

        if (second == head) {
            return head.next;
        } else {
            preSecond.next = second.next;
        }
        return head;
    }


}
