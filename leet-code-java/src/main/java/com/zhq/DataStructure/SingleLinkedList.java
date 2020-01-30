package com.zhq.DataStructure;

/**
 * @program: LeetCodeTest
 * @description: SingleLinkedList Test
 * @author: ZHQ
 * @create: 2018-10-21 10:24
 **/
public class SingleLinkedList {

    private int length;
    private Node head;

    private class Node {
        private Object data;
        private Node nextNode;

        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }

        // TODO: 2018/10/21
        // 这个函数为什么不能用
        public void output() {
            System.out.println(data);
        }
    }

    public SingleLinkedList() {
        this.length = 0;
        this.head = null;
    }

    // 在列表头中插入元素
    public Node addHead(Object data) {

        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
        } else {
            newNode.nextNode = head;
            head = newNode;
        }
        length++;
        return newNode;
    }

    // 在列表头中删除元素
    public boolean delHeadNode() {

        if (length == 0) {
            return false;
        }
        head = head.nextNode;
        length--;
        return true;
    }


    // 查找给定元素
    public Node getData(Object data) {

        if ( length == 0) {
            return null;
        }
        Node current = head;
        int tempLength = length;
        while (tempLength > 0) {
            if (data.equals(current.data)) {
                return current;
            } else {
                current = current.nextNode;
                tempLength--;
            }
        }
        return null;
    }


    // 删除给定元素
    public boolean delData (Object data) {

        if (length == 0) {
            return false;
        } else if ( length == 1) {
            if (data.equals(head.data)) {
                head = null;
                length = 0;
                return true;
            } else {
                return false;
            }
        } else {
            // 删除的是头结点
            if (data.equals(head.data)) {
                head = head.nextNode;
                length--;
                return true;
            } else {
                int tempLength = length;
                Node current = head.nextNode;
                Node previous = head;
                while (tempLength > 0) {
                    if (data.equals(current.data)) {
                        previous.nextNode = current.nextNode;
                        length--;
                        return true;
                    }
                    tempLength--;
                    current = current.nextNode;
                    previous = previous.nextNode;
                }
            }
            return false;
        }

    }



    // 是否为空
    public boolean isEmpty() {
        return length == 0;
    }

    // 显示链表
    public void display() {
        if (length == 0) return;

        int tempLength = length;
        Node current = head;
        while(tempLength > 0) {
            if( current.nextNode == null) {
                System.out.println(current.data);
            } else {
                System.out.print(current.data + "->");
            }
            current = current.nextNode;
            tempLength--;
        }

    }


    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList();
        list.addHead("A");
        list.addHead("B");
        list.addHead("C");
        list.addHead("D");
        list.addHead("E");
        list.display();

//        list.delData("C");
//        list.display();
//        list.delHeadNode();
//        list.display();
//        System.out.println(list.length);

        System.out.println(list.getData("A"));

        SingleLinkedList linkedList = new SingleLinkedList();
        SingleLinkedList.Node node = linkedList.new Node();
        node = list.getData("A");
        System.out.println(node.data);


    }



}
