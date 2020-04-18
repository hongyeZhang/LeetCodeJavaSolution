package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author : ZHQ
 * @date : 2020/4/18
 */
public class Test347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> retList = new ArrayList<>();
        if (null == nums || k <= 0 || nums.length < k) {
            return retList;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Comparator<Map.Entry<Integer, Integer>> comparator =
                        new Comparator<Map.Entry<Integer, Integer>>() {
                            @Override
                            public int compare(Map.Entry<Integer, Integer> o1,
                                            Map.Entry<Integer, Integer> o2) {
                                return o1.getValue() - o2.getValue();
                            }
                        };
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(comparator);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                Map.Entry<Integer, Integer> peekEntry = minHeap.peek();
                if (peekEntry.getValue() < entry.getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }

        while (!minHeap.isEmpty()) {
            retList.add(minHeap.poll().getKey());
        }
        return retList;
    }

    @Test
    public void test() {
        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
        int k = 2;

        List<Integer> list = topKFrequent(nums, k);

        System.out.println(list);
    }




}
