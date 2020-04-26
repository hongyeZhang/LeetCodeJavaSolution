package com.zhq;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/25
 */
public class Interview36_3 {

    public static class Node {
        public int val;

        public Node left;

        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head, pre;

    /**
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
     *
     * 讲解
     *
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }
        inOrder(root);
        pre.right = head;
        head.left = pre;

        return head;
    }

    public void inOrder(Node current) {
        if (null == current) {
            return;
        }
        inOrder(current.left);

        if (null != pre) {
            pre.right = current;
        } else {
            head = current;
        }
        current.left = pre;
        pre = current;
        inOrder(current.right);
    }

    @Test
    public void test() {
        Node node1 = new Node(1, null, null);
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(2, node1, node3);
        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, node2, node5);
        treeToDoublyList(node4);
    }

}
