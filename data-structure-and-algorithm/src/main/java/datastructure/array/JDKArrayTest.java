package datastructure.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : ZHQ
 * @date : 2020/3/5
 */
public class JDKArrayTest {
    public static void main(String[] args) {
        test2();





    }

    public static void test1() {
        Deque<Integer> queue = new ArrayDeque();
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        while (!queue.isEmpty()) {
            System.out.println(queue.pollLast());
        }
    }

    public static void test2() {
        Deque<Integer> queue = new ArrayDeque();
        queue.addFirst(3);
        queue.addFirst(2);
        queue.addFirst(1);

        while (!queue.isEmpty()) {
            System.out.println(queue.pollLast());
        }




    }
}
