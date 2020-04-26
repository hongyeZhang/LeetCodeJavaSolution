package com.zhq;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/3/2
 */
public class Interview36 {

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    Node pre = null;

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }

        Node p = root, q = root;
        while (p.left != null) {
            p = p.left;
        }
        while (q.right != null) {
            q = q.right;
        }

        inorder(root);
        p.left = q;
        q.right = p;
        return p;

    }

    public void inorder(Node curr) {
        if (curr == null) {
            return;
        }
        inorder(curr.left);

        curr.left = this.pre;
        if (this.pre != null) {
            this.pre.right = curr;
        }
        pre = curr;

        inorder(curr.right);
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
