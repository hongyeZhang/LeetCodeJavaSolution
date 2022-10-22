package com.zhq.HardProblem;

import com.zhq.common.ListNode;
import com.zhq.util.ListNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author : ZHQ
 * @date : 2020/1/31
 */
public class Test23 {


    @Test
    public void test() {
        int[] nums1 = new int[]{1, 4, 5};
        ListNode node1 = ListNodeUtils.constructList(nums1);
        int[] nums2 = new int[]{1, 3, 4};
        ListNode node2 = ListNodeUtils.constructList(nums2);
        int[] nums3 = new int[]{2, 6};
        ListNode node3 = ListNodeUtils.constructList(nums3);
        ListNode[] inputArr = new ListNode[3];
        inputArr[0] = node1;
        inputArr[1] = node2;
        inputArr[2] = node3;

        ListNode node = mergeKListsFourth(inputArr);
        ListNodeUtils.printSingleList(node);
    }


    /** 暴力求解，先将所有链表的数据存储到一个数组中，再对数组排序，根据排好序的数组构建一个新的链表
     *  时间复杂度 ： O(NlogN)
     *  空间复杂度 ： O(N)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
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

    /**
     * 多次对称合并
     * @param lists
     * @return
     */
    public ListNode mergeKListsSecond(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        // 将n个链表以中间为对称，合并，即合并
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = ListNodeUtils.mergeTwoLists(lists[i], lists[len - 1 - i]);
            }
            len = (len + 1) / 2;
        }
        return lists[0];
    }

    public ListNode mergeKListsThird(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.length; ++i) {
            while (lists[i] != null) {
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while (!queue.isEmpty()) {
            ListNode tmpNode = queue.poll();
            // 如果不加这句，会造成循环
            tmpNode.next = null;
            current.next = tmpNode;
            current = current.next;
        }
        return dummyNode.next;
    }

    /**
     * 时间复杂度: O(NlogK) 解释：优先队列中的元素个数最多是 k ， poll() add() 方法的时间复杂度是O(logk)； 链表的节点总数是 N
     * @param lists
     * @return
     */
    public ListNode mergeKListsFourth(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        int k = lists.length;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < k; ++i) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while (!minHeap.isEmpty()) {
            ListNode tmpNode = minHeap.poll();
            current.next = tmpNode;
            current = current.next;
            if (tmpNode.next != null) {
                minHeap.add(tmpNode.next);
            }
        }
        return dummyNode.next;
    }



}
