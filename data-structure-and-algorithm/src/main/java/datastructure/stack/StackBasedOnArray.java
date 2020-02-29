package datastructure.stack;

/**
 * @program: data-structure-and-algorithm
 * @description: 基于数组实现的栈
 * @author: ZHQ
 * @create: 2019-06-20 22:59
 **/
public class StackBasedOnArray {
    private int[] items;
    private int size;
    private int top;

    public StackBasedOnArray() {
        this(10);
    }

    public StackBasedOnArray(int capacity) {
        items = new int[capacity];
        this.size = capacity;
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
    **/
    public boolean push(int value) {
        if (top == size - 1) {
            throw new RuntimeException("stack is full");
        } else {
            items[++top] = value;
            return true;
        }
    }

    /**
     * 查看栈顶元素但不弹出
     **/
    public int peek() {
        if (top == -1) {
            throw new RuntimeException("stack is empty");
        }
        return items[top];
    }

    /**
     * 出栈
     **/
    public int pop() {
        if (top == -1) {
            throw new RuntimeException("stack is empty");
        }
        int ret = items[top];
        top--;
        return ret;
    }

    public void printStack() {
        if (top == -1) {
            throw new RuntimeException("stack is empty");
        }
        for (int i = 0; i <= top; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackBasedOnArray stack = new StackBasedOnArray(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printStack();
        stack.pop();
        stack.printStack();
    }


}
