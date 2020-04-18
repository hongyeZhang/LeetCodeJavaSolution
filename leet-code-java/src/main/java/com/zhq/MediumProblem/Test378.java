package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author : ZHQ
 * @date : 2020/4/18
 */
public class Test378 {

    public int kthSmallest(int[][] matrix, int k) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0 || k <= 0) {
            return 0;
        }

        int rowMax = matrix.length;
        int colMax = matrix[0].length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < rowMax; ++i) {
            for (int j = 0; j < colMax; ++j) {
                maxHeap.offer(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.peek();
    }

    @Test
    public void test() {
        int[][] matrix = new int[][] {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};

        System.out.println(kthSmallest(matrix, 8));

    }

}
