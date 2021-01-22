package com.zhq.tree;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: ZHQ
 * @Date: 2020/12/17
 */
public class Test752 {


    public int openLock(String[] deadends, String target) {
        if (target == null) {
            return -1;
        }
        Set<String> deadSet = new HashSet<>();
        for (String deadend : deadends) {
            deadSet.add(deadend);
        }

        String start = "0000";
        if (deadSet.contains(start)) {
            return -1;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (target.equals(current)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(current, j);
                    if (!visited.contains(up) && !deadSet.contains(up)) {
                        visited.add(up);
                        queue.add(up);
                    }

                    String down = subtractOne(current, j);
                    if (!visited.contains(down) && !deadSet.contains(down)) {
                        visited.add(down);
                        queue.add(down);
                    }
                }
            }
            step++;
        }

        return -1;
    }


    public String plusOne(String input, int index) {
        char[] chars = input.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] += 1;
        }
        return new String(chars);
    }

    public String subtractOne(String input, int index) {
        char[] chars = input.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] -= 1;
        }
        return new String(chars);
    }

    @Test
    public void test() {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }

    @Test
    public void testplusOne() {
        System.out.println(plusOne("9000", 0));
    }

}
