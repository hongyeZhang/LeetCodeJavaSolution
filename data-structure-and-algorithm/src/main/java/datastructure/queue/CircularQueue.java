package datastructure.queue;

import datastructure.linkedlist.CircularLinkedList;

/**
 * @program: data-structure-and-algorithm
 * @description: 循环队列
 * @author: ZHQ
 * @create: 2019-06-20 23:29
 **/
public class CircularQueue {
    /**
     *  数组：items，数组大小：n
     **/
    private int[] items;
    private int size = 0;
    /**
     *  head表示队头下标，tail表示队尾下标
     **/
    private int head = 0;
    private int tail = 0;

    public CircularQueue() {
        this(10);
    }

    public CircularQueue(int capacity) {
        items = new int[capacity];
        size = capacity;
    }

    /**
     *  入队
     **/
    public boolean enqueue(int item) {
        if ((tail+1) % size == head) {
            throw new RuntimeException("queue is full");
        }
        items[tail] = item;
        tail = (++tail) % size;
        return true;
    }

    /**
     *  出队
     **/
    public int dequeue() {
        if (head == tail) {
            throw new RuntimeException("queue is full");
        }
        int ret = items[head];
        head = (++head) % size;
        return ret;
    }

    public void printAll() {
        for (int i = head; i % size != tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.printAll();
    }








}
