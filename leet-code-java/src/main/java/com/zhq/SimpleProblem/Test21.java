package com.zhq.SimpleProblem;


import com.zhq.common.ListNode;
import com.zhq.util.ListNodeUtils;
import org.junit.Test;

/**
 * @program: LeetCodeTest
 * @description: 合并两个有序链表
 * @author: ZHQ
 * @create: 2019-07-02
 **/
public class Test21 {

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 3, 4};
        ListNode node1 = ListNodeUtils.constructList(nums1);
        ListNodeUtils.printSingleList(node1);

        int[] nums2 = new int[]{1, 2, 4};
        ListNode node2 = ListNodeUtils.constructList(nums2);
        ListNodeUtils.printSingleList(node2);

        ListNodeUtils.printSingleList(mergeTwoLists(node1, node2));
    }


    /**
     * @Description: 类似于拉拉链的算法
     * @Param:
     * @return:
     * @Author: ZHQ
     * @Date: 2019-07-02
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
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
        }
        if (l2 != null) {
            p.next = l2;
        }
        return dummy.next;
    }


}
