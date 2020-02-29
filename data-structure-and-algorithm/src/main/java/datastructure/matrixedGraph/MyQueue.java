package datastructure.matrixedGraph;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-08-09
 **/
public class MyQueue<E> {
    private Object[] data;
    private int maxSize; //队列容量
    private int front;  //队列头，允许删除
    private int rear;   //队列尾，允许插入

    //构造函数
    public MyQueue() {
        this(10);
    }

    public MyQueue(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            front = rear = 0;
        } else {
            throw new RuntimeException("初始化大小不能小于0：" + initialSize);
        }
    }

    //判空
    public boolean isEmpty() {
        return rear == front ? true : false;
    }

    //插入
    public boolean add(E e) {
        if (rear == maxSize) {
            throw new RuntimeException("队列已满，无法插入新的元素！");
        } else {
            data[rear++] = e;
            return true;
        }
    }

    //返回队首元素，但不删除
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("空队列异常！");
        } else {
            return (E) data[front];
        }
    }

    //出队
    public E poll() {
        if (isEmpty()) {
            throw new RuntimeException("空队列异常！");
        } else {
            E value = (E) data[front];  // 保留队列的front端的元素的值
            data[front++] = null;     // 释放队列的front端的元素
            return value;
        }
    }

    //队列长度
    public int length() {
        return rear - front;
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }

        int size = queue.length();
        for (int i = 0; i < size; i++) {
            System.out.print(queue.poll() + " ");
        }
    }


}
