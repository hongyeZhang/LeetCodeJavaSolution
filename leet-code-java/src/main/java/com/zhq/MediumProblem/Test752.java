package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/3/12 10:13
 */
public class Test752 {

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains(target) || deadSet.contains("0000")) {
            return -1;
        }
        queue.add("0000");
        visited.add("0000");
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String poll = queue.poll();
                if (poll.equals(target)) {
                    return count;
                }
                for (int j = 0; j < 4; ++j) {
                    String plusOne = plusOne(poll, j);
                    if (!deadSet.contains(plusOne) && !visited.contains(plusOne)) {
                        queue.add(plusOne);
                        visited.add(plusOne);
                    }
                    String minusOne = minusOne(poll, j);
                    if (!deadSet.contains(minusOne) && !visited.contains(minusOne)) {
                        queue.add(minusOne);
                        visited.add(minusOne);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public String plusOne(String str, int i) {
        char[] chars = str.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return new String(chars);
    }

    public String minusOne(String str, int i) {
        char[] chars = str.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }


    @Test
    public void test() {
        String[] deadends = new String[]{"0000"};
        String target = "8888";
        System.out.println(openLock(deadends, target));
    }
}
