package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/12 20:44
 */
public class Test116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    /**
     * 递归的方式，连接两个节点
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    public void connectTwoNode(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);
        connectTwoNode(left.right, right.left);
    }


    /**
     * 方法1：其实就是层序遍历
     * 方法2：通过递归的方式解决
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null || root.left == null || root.right == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size >= 2) {
                Node preNode = queue.poll();
                if (preNode.left != null) {
                    queue.add(preNode.left);
                }
                if (preNode.right != null) {
                    queue.add(preNode.right);
                }
                Node curNode = queue.poll();
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                preNode.next = curNode;
                for (int i = 2; i < size; i++) {
                    preNode = curNode;
                    curNode = queue.poll();
                    if (curNode.left != null) {
                        queue.add(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.add(curNode.right);
                    }
                    preNode.next = curNode;
                }
            }
        }
        return root;
    }

    @Test
    public void test() {
        Node node4 = new Node(4, null, null, null);
        Node node5 = new Node(5, null, null, null);
        Node node6 = new Node(6, null, null, null);
        Node node7 = new Node(7, null, null, null);

        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, node6, node7, null);

        Node node1 = new Node(1, node2, node3, null);

        Node connect = connect2(node1);
        System.out.println();


    }

}
