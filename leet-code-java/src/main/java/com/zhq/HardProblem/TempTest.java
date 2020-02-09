package com.zhq.HardProblem;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-06-15
 **/
public class TempTest {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next > 2 && next < 5) {
                iterator.remove();
            }
        }
        System.out.println(list);


    }



}
