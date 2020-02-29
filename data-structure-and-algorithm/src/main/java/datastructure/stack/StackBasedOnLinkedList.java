package datastructure.stack;

/**
 * @program: data-structure-and-algorithm
 * @description: 基于链表实现的栈
 * @author: ZHQ
 * @create: 2019-06-20 22:59
 **/
public class StackBasedOnLinkedList {
    private Node top;
    private int size;

    public StackBasedOnLinkedList() {
        top = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * 入栈
    **/
    public boolean push(int value) {
        Node tempNode = new Node(value);
        if (top == null) {
            top = tempNode;
            size++;
            return true;
        } else {
            tempNode.next = top;
            top = tempNode;
            size++;
            return true;
        }
    }

    /**
     * 出栈
     **/
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int ret = top.data;
        top = top.next;
        size--;
        return ret;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

}
