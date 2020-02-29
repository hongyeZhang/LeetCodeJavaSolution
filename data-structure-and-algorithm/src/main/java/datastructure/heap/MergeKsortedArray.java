package datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: data-structure-and-algorithm
 * @description: 合并k个排序数组
 *    最简单的方法是创建一个N大小的数组，然后把所有数字拷贝进去，然后再进行时间复杂度为O(NlogN)排序算法，这样总体时间复杂度为O(NlogN)
 * 可以利用最小堆完成，时间复杂度是O(Nlogk)，具体过程如下：
 * 创建一个大小为N的数组保存最后的结果
 * 数组本身已经从小到大排好序，所以我们只需创建一个大小为k的最小堆，堆中初始元素为k个数组中的每个数组的第一个元素，每次从堆中取出最小元素（堆顶元素），并将其存入输出数组中，将堆顶元素所在行的下一元素加入堆，重新排列出堆顶元素，时间复杂度为logk，总共N个元素，所以总体时间复杂度是Nlogk
 * @author: ZHQ
 * @create: 2019-07-20 23:15
 **/
public class MergeKsortedArray {
    public static class Element {
        public int row;
        public int col;
        public int val;

        public Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public static int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null) {
            return new int[0];
        }

        // 构造容量为 k 的最小堆
        int k = arrays.length;
        Comparator<Element> comparator = new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.val - o2.val;
            }
        };
        Queue<Element> queue = new PriorityQueue<>(k,comparator);

        int totalSize = 0;
        for (int i = 0; i < arrays.length; ++i) {
            if (arrays[i].length > 0) {
                Element element = new Element(i, 0, arrays[i][0]);
                queue.add(element);
                totalSize += arrays[i].length;
            }
        }

        int[] result = new int[totalSize];
        int index = 0;
        while (!queue.isEmpty()) {
            Element element = queue.poll();
            result[index++] = element.val;
            if (element.col + 1 < arrays[element.row].length) {
                Element nextElement = new Element(element.row, element.col + 1, arrays[element.row][element.col + 1]);
                queue.add(nextElement);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arrays = new int[3][];
        arrays[0] = new int[]{1, 3, 5, 7};
        arrays[1] = new int[]{2, 4, 6};
        arrays[2] = new int[]{0, 8, 9, 10, 11};
        for (int i = 0; i < arrays.length; ++i) {
            for (int j = 0; j < arrays[i].length; ++j) {
                System.out.print(arrays[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("sorted array");
        int[] ret = mergekSortedArrays(arrays);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + "\t");
        }

    }




}
