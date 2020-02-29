package datastructure.linkedGraph;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-08-09
 **/
public class MyStack<E> {
    private Object[] data;
    private int maxSize;   //栈容量
    private int top;  //栈顶指针

    public MyStack() {
        this(10);

    }

    MyStack(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            top = -1;
        } else {
            throw new RuntimeException("初始化大小不能小于0：" + initialSize);
        }
    }

    //进栈,第一个元素top=0；
    public boolean push(E e) {
        if (top == maxSize - 1) {
            throw new RuntimeException("栈已满，无法将元素入栈！");
        } else {
            data[++top] = e;
            return true;
        }
    }

    //查看栈顶元素但不移除
    public E peek() {
        if (top == -1) {
            throw new RuntimeException("栈为空！");
        } else {
            return (E) data[top];
        }
    }

    //弹出栈顶元素
    public E pop() {
        if (top == -1) {
            throw new RuntimeException("栈为空！");
        } else {
            return (E) data[top--];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //返回对象在堆栈中的位置，以 1 为基数
    public int search(E e) {
        int i = top;
        while (top != -1) {
            if (peek() != e) {
                top--;
            } else {
                break;
            }
        }
        int result = top + 1;
        top = i;
        return result;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(stack.pop() + " ");
        }
    }


}
