package datastructure.queue;

/**
 * @program: data-structure-and-algorithm
 * @description: 链表实现的队列
 * @author: ZHQ
 * @create: 2019-06-20 23:31
 **/
public class QueueBasedOnLinkedList {
    private Node head;
    private Node tail;

    public QueueBasedOnLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     *  入队
     **/
    public void enqueue(int value) {
        Node tempNode = new Node(value);
        if (head == null) {
            head = tempNode;
            tail = tempNode;
        } else {
            tail.next = tempNode;
            tail = tempNode;
        }
    }

    /**
     *  出队
     **/
    public int dequeue() {
        if (head == null) {
            throw new RuntimeException("queue is empty");
        }
        int ret = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return ret;
    }

    public void printQueue() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static class Node {
        private int data;
        private Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.printQueue();

        queue.dequeue();
        queue.printQueue();

    }
}
