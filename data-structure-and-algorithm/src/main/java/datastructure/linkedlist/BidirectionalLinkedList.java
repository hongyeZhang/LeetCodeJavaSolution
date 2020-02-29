package datastructure.linkedlist;

/**
 * @program: data-structure-and-algorithm
 * @description: 双向链表基本操作
 * @author: ZHQ
 * @create: 2019-06-20 21:56
 **/
public class BidirectionalLinkedList {
    private Node head;
    private Node tail;

    public BidirectionalLinkedList() {
        head = null;
        tail = null;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        BidirectionalLinkedList list = new BidirectionalLinkedList();

//        list.addHead(node1);
//        list.addHead(node2);
//        list.addHead(node3);
//        list.addHead(node4);
//        list.printForward();
//        list.printBackward();

//        list.addTail(node1);
//        list.addTail(node2);
//        list.addTail(node3);
//        list.addTail(node4);
//        list.printForward();
//        list.printBackward();

//        list.addTail(node1);
//        list.addTail(node2);
//        list.addTail(node3);
//        list.addBefore(1, 4);
//        list.printForward();
//        list.printBackward();

//        list.addTail(node1);
//        list.addTail(node2);
//        list.addTail(node3);
//        list.addAfter(2, 4);
//        list.printForward();
//        list.printBackward();

//        list.addTail(node1);
//        list.addTail(node2);
//        list.addTail(node3);
//        list.addTail(node4);
//        list.deleteHead();
//        list.printForward();
//        list.printBackward();
//        list.deleteTail();
//        list.printForward();
//        list.printBackward();

//        list.addTail(node1);
//        list.addTail(node2);
//        list.addTail(node3);
//        list.addTail(node4);
//        System.out.println(list.size());

        list.addTail(node1);
        list.addTail(node2);
        list.addTail(node3);
        list.addTail(node4);
        list.deleteNodeByValue(4);
        list.printForward();
        list.printBackward();
    }


    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    /**
     *  头部插入元素
     **/
    public void addHead(Node node) {
        if (isEmpty()) {
            tail = node;
            head = node;
        } else {
            head.pre = node;
            node.next = head;
            head = node;
        }
    }

    /**
     *  尾部插入元素
     **/
    public void addTail(Node node) {
        if (isEmpty()) {
            tail = node;
            head = node;
        } else {
            node.pre = tail;
            tail.next = node;
            tail = node;
        }
    }

    /**
     *  删除头
     **/
    public void deleteHead() {
        if (head.next == null) {
            // 一个元素
            head = null;
            tail = null;
        } else {
            head.next.pre = null;
            head = head.next;
        }
    }

    /**
     *  删除尾
     **/
    public void deleteTail() {
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            tail.pre.next = null;
            tail = tail.pre;
        }
    }


    /**
     *  删除指定值的节点
     **/
    public void deleteNodeByValue(int value) {
        if (isEmpty()) {
            throw new RuntimeException("wrong operation, no element : " + value);
        }
        if (head.data == value) {
            deleteHead();
            return;
        }
        if (tail.data == value) {
            deleteTail();
            return;
        }
        // 删除中间元素
        Node current = head;
        Node preCurrent = null;
        while (current != null && current.data != value) {
            preCurrent = current;
            current = current.next;
        }
        if (current == null) {
            throw new RuntimeException("wrong operation, no element : " + value);
        }
        preCurrent.next = current.next;
        current.next.pre = preCurrent;
    }

    /**
     *  在某元素之前插入元素（不考虑重复元素）
     **/
    public boolean addBefore(int key, int value){
        // 头部插入
        if (head.data == key) {
            addHead(new Node(value));
            return true;
        }

        // 中间插入
        Node current = head;
        Node preCurrent = null;
        while (current != null && current.data != key) {
            preCurrent = current;
            current = current.next;
        }
        if (current == null) {
            throw new RuntimeException("wrong operation, no element : " + key);
        }
        Node tempNode = new Node(value);
        preCurrent.next = tempNode;
        tempNode.pre = preCurrent;
        tempNode.next = current;
        current.pre = tempNode;
        return true;
    }

    /**
     *  在某元素之后插入元素（不考虑重复元素）
     **/
    public boolean addAfter(int key, int value) {
        // 尾部插入
        if (tail.data == value) {
            addTail(new Node(value));
            return true;
        }

        // 其他位置插入
        Node current = head;
        Node postCurrent = current.next;
        while (current.next != null && current.data != key) {
            current = current.next;
            if (current.next == null) {
                // 最后一个元素了，不可能存在，之前已经判断过
                throw new RuntimeException("wrong operation, no element : " + key);
            } else {
                postCurrent = current.next;
            }
        }
        if (current == null || postCurrent == null) {
            throw new RuntimeException("wrong operation, no element : " + key);
        }
        Node tempNode = new Node(value);
        current.next = tempNode;
        tempNode.pre = current;
        tempNode.next = postCurrent;
        postCurrent.pre = tempNode;

        return true;
    }

    /**
     *  正序输出
     **/
    public void printForward() {
        if (isEmpty()) {
            throw new RuntimeException("empty bidirectional linked list");
        }
        Node current = head;
        while (current != tail) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println(tail.data);
    }

    /**
     *  逆序输出
     **/
    public void printBackward() {
        if (isEmpty()) {
            throw new RuntimeException("empty bidirectional linked list");
        }
        Node current = tail;
        while (current != head) {
            System.out.print(current.data + "->");
            current = current.pre;
        }
        System.out.println(head.data);
    }

    public static class Node {
        private int data;
        private Node pre;
        private Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
            this.pre = null;
            this.next = null;
        }

        public Node(int data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

}
