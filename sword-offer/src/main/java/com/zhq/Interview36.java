package com.zhq;

import sun.misc.Unsafe;

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


    public static Node treeToDoublyList(Node root) {
        // TODO: 2020/3/2   直接翻译的教材，没看明白，运行结果也是错的
        Node lastNodeInList = null;
        convertNode(root, lastNodeInList);
        Node head = lastNodeInList;
        while ((head != null) && (head.left != null)) {
            head = head.left;
        }
        return head;
    }

    public static void convertNode(Node node, Node lastNodeInList) {
        if (null == node) {
            return;
        }
        Node current = node;
        if (current.left != null) {
            convertNode(current.left, lastNodeInList);
        }
        current.left = lastNodeInList;
        if (null != lastNodeInList) {
            lastNodeInList.right = current;
        }
        lastNodeInList = current;
        if (null != current.right) {
            convertNode(current.right, lastNodeInList);
        }
    }





    public static void main(String[] args) {
        Node node1 = new Node(1, null, null);
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(2, node1, node3);
        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, node2, node5);

        treeToDoublyList(node4);

    }

}
