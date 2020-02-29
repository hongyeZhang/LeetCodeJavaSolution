package datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: data-structure-and-algorithm
 * @description:  合并 K 个有序数组
 *
 * 一. 最简单的方法是创建一个n*k大小的数组，然后把所有数字拷贝进去，然后再进行时间复杂度为O(nlogn)排序算法，这样总体时间复杂度为O(nklognk)
 *
 * 二. 可以利用最小堆完成，时间复杂度是O(nklogk)，具体过程如下：
 *
 *         创建一个大小为n*k的数组保存最后的结果
 *         创建一个大小为k的最小堆，堆中元素为k个数组中的每个数组的第一个元素
 *         重复下列步骤n*k次：
 *             每次从堆中取出最小元素（堆顶元素），并将其存入输出数组中
 *             用堆顶元素所在数组的下一元素将堆顶元素替换掉，
 *             如果数组中元素被取光了，将堆顶元素替换为无穷大。每次替换堆顶元素后，重新调整堆
 * ---------------------
 * 作者：听了个听儿
 * 来源：CSDN
 * 原文：https://blog.csdn.net/u012328476/article/details/52522900
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 *
 *
 * @author: ZHQ
 * @create: 2019-07-20 20:47
 **/
public class mergeKsortedList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode merge(ListNode[] arr) {
        int k = arr.length;
        ListNode dumy = new ListNode(-1);
        ListNode p = dumy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(k, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }

        while (!minHeap.isEmpty()) {
            ListNode tmp = minHeap.poll();
            if (tmp.next != null) {
                minHeap.offer(tmp.next);
            }
            p.next = tmp;
            p = p.next;
        }
        return dumy.next;
    }

    //测试代码
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(2);
        a1.next.next = new ListNode(3);
        a1.next.next.next = new ListNode(100);

        ListNode b1 = new ListNode(1);
        b1.next = new ListNode(2);
        b1.next.next = new ListNode(3);

        ListNode c1 = new ListNode(2);
        c1.next = new ListNode(3);
        c1.next.next = new ListNode(5);

        ListNode[] arr = {a1, b1, c1};

        ListNode res = merge(arr);
        while (res!= null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

}
