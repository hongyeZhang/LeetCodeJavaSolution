package com.zhq.java.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Integer next = listIterator.next();
            System.out.println(next);
            if (next == 2) {
                break;
            }
        }


    }




}
