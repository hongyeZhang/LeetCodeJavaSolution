package datastructure.queue;

/**
 * @program: data-structure-and-algorithm
 * @description: 用数组实现的队列
 * @author: ZHQ
 * @create: 2019-06-20 23:07
 **/
public class ArrayQueue {
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

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        items = new int[capacity];
        size = capacity;
    }

    /**
     *  入队
     **/
    public boolean enqueue(int item) {
        if (tail == size) {
            throw new RuntimeException("queue is full");
        }
        items[tail] = item;
        tail++;
        return true;
    }

    /**
     *  出队
     **/
    public int dequeue() {
        if (head == tail) {
            throw new RuntimeException("queue is empty");
        }
        int ret = items[head];
        head++;
        return ret;
    }


    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.printAll();

        queue.dequeue();
        queue.printAll();

    }







}
