package datastructure.linkedlist;

import java.security.SignatureException;

/**
 * @program: data-structure-and-algorithm
 * @description: 循环链表
 * @author: ZHQ
 * @create: 2019-06-20 22:36
 **/
public class CircularLinkedList {
    private Node head = null;

    public CircularLinkedList() {
    }

    public CircularLinkedList(Node head) {
        this.head = head;
        head.next = head;
    }

    /**
     *  获取链表大小
     **/
    public int size() {
        int size = 1;
        Node current = head;
        while (current.next != head) {
            current = current.next;
            size++;
        }
        return size;
    }

    /**
     *  插入结点
     **/
    public void insertNode(Node node) {
        if (head.next == head) {
            //第一次插入链表
            head.next = node;
            node.next = head;
        } else {
            // 链表中已经存在数据
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = node;
            node.next = head;
        }
    }

    /**
     *  删除结点
     **/
    public void deleteNode(int value) {
        // 头结点、中间结点、尾节点
        Node current = head;
        Node preCurrent = null;
        // 删除头结点
        if (head.data == value) {
            //先找到尾结点
            Node tempCurr = head;
            while (tempCurr.next != head) {
                tempCurr = tempCurr.next;
            }
            tempCurr.next = head.next;
            head = tempCurr.next;
            return;
        }
        // 删除中间结点
        while (current.next != head) {
            if (current.data == value) {
                preCurrent.next = current.next;
                break;
            }
            preCurrent = current;
            current = current.next;
        }

        // 删除最后一个结点
        if (current.next == head) {
            preCurrent.next = head;
        }
    }

    /**
     *  获取第i个结点
     **/
    public Node findNodeByIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new RuntimeException("IndexOutOfBoundException");
        }

        Node current = head;
        int tempIndex = 0;
        while (tempIndex < index) {
            current = current.next;
            tempIndex++;
        }
        return current;
    }

    public void printList() {
        Node current = head;
        while (current.next != head) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print(current.data);
        System.out.println();
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        CircularLinkedList list = new CircularLinkedList(node1);
        list.insertNode(node2);
        list.insertNode(node3);
        list.insertNode(node4);

//        list.printList();
//        System.out.println(list.size());
//
//        list.deleteNode(1);
//        list.printList();
//        System.out.println(list.size());
        list.printList();
        System.out.println(list.findNodeByIndex(0).data);
        System.out.println(list.findNodeByIndex(3).data);


    }



    public static class Node {
        private int data;
        private Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
