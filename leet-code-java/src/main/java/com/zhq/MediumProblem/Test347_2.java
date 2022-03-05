package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/2/23 10:20
 */
public class Test347_2 {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k <= 0) {
            return new int[]{};
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = (o1, o2) -> o1.getValue() - o2.getValue();
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(comparator);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(entry);
            } else {
                Map.Entry<Integer, Integer> peek = priorityQueue.peek();
                if (peek.getValue() < entry.getValue()) {
                    priorityQueue.poll();
                    priorityQueue.offer(entry);
                }
            }
        }

        int[] rets = new int[k];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            rets[index++] = priorityQueue.poll().getKey();
        }
        return rets;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] ints = topKFrequent(nums, 2);
        for (int anInt : ints) {
            System.out.print(anInt + "\t");
        }

    }
}
