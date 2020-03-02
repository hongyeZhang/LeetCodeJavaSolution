package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/2
 */
public class Interview35 {
    public static class Node {
        int val;

        Node next;

        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }

    }


    public static Node copyRandomList(Node head) {
        // TODO: 2020/3/2  了解思路，有时间再做
        return null;

    }

    public static void main(String[] args) {


    }


}
