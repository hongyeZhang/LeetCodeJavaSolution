package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author : ZHQ
 * @date : 2020/4/18
 */
public class Test279_3 {

    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }

        Deque<Integer> deque = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        deque.offer(n);
        int level = 0;
        while (!deque.isEmpty()) {
            level++;
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                Integer node = deque.pollFirst();
                for (int j = 1; j * j <= node; ++j) {
                    int next = node - j * j;
                    if (next == 0) {
                        return level;
                    }
                    if (!visited.contains(next)) {
                        visited.add(next);
                        deque.offer(next);
                    }
                }
            }

        }

        return level;
    }

    @Test
    public void test() {

        System.out.println(numSquares(12));
        System.out.println(numSquares(13));

    }
}
