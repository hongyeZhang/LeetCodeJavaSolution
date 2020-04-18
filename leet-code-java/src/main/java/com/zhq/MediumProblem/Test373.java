package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;

/**
 * @author : ZHQ
 * @date : 2020/4/18
 */
public class Test373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> retList = new ArrayList<>();
        if (null == nums1 || null == nums2 || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return retList;
        }

        Comparator<Pair<Integer, Integer>> comparator = new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return (o2.getKey() + o2.getValue()) - (o1.getKey() + o1.getValue());
            }
        };
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(comparator);

        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len1; ++i) {
            for (int j = 0; j < len2; ++j) {
                minHeap.offer(new Pair<>(nums1[i], nums2[j]));
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }

        while (!minHeap.isEmpty()) {
            Pair<Integer, Integer> poll = minHeap.poll();
            retList.add(Arrays.asList(poll.getKey(), poll.getValue()));
        }

        return retList;
    }

    @Test
    public void test() {
        int[] nums1 = new int[] {1, 7, 11};
        int[] nums2 = new int[] {2, 4, 6};
        int k = 3;

        List<List<Integer>> lists = kSmallestPairs(nums1, nums2, k);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }


}
