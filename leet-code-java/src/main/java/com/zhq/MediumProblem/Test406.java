package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author : ZHQ
 * @date : 2020/4/13
 */
public class Test406 {

    /**
     *
     *      * 解题思路：先排序再插入
     *      * 1.排序规则：按照先H高度降序，K个数升序排序
     *      * 2.遍历排序后的数组，根据K插入到K的位置上
     *      *
     *      * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     *
     *         // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
     *         // 再一个一个插入
     *         // [7,0]
     *         // [7,0], [7,1]
     *         // [7,0], [6,1], [7,1]
     *         // [5,0], [7,0], [6,1], [7,1]
     *         // [5,0], [7,0], [5,2], [6,1], [7,1]
     *         // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
     *
     * 作者：pphdsny
     * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/406-gen-ju-shen-gao-zhong-jian-dui-lie-java-xian-p/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        };
        Arrays.sort(people, comparator);
        LinkedList<int[]> resultList = new LinkedList<>();
        for (int[] person : people) {
            resultList.add(person[1], person);
        }
        int len = people.length;
        return resultList.toArray(new int[len][2]);
    }


    @Test
    public void test() {
        int[][] people = new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        };
        Arrays.sort(people, comparator);
        for (int[] person : people) {
            for (int i : person) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }


        LinkedList<int[]> resultList = new LinkedList<>();
        for (int[] person : people) {
            resultList.add(person[1], person);
        }

        int len = people.length;
        int[][] results = resultList.toArray(new int[len][2]);

        System.out.println("next");

        for (int[] result : results) {
            for (int i : result) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }





}
