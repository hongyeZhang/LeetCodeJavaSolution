package com.zhq.MediumProblem;

/**
 * @author ZHQ
 * @date 2018/10/17 23:45
 */
public class Test2 {

    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
    * @Description: 时间复杂度O(max(m,n)), 空间复杂度O(max(m,n))
    * @Param: [l1, l2]
    * @return: Common.ListNode
    * @Author: ZHQ
    * @Date: 2018/10/21
    **/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyNode = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyNode;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p == null) ? 0 : p.val;
            int y = (q == null) ? 0 : q.val;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if(p != null){ p = p.next;}
            if(q != null){ q = q.next;}

        }
        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode tempL1 = l1;
        tempL1.next = new ListNode(4);
        tempL1 = tempL1.next;
        tempL1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode tempL2 = l2;
        tempL2.next = new ListNode(6);
        tempL2 = tempL2.next;
        tempL2.next = new ListNode(4);

/*        ListNode l1 = new ListNode(1);
        ListNode tempL1 = l1;
        tempL1.next = new ListNode(8);

        ListNode l2 = new ListNode(0);*/


        ListNode res = addTwoNumbers(l1, l2);

        ListNode current = res;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }

    }
}
