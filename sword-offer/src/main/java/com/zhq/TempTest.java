package com.zhq;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class TempTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.size());

        while (list.size() > 1) {
            list.remove(list.size() - 1);
        }

        System.out.println(list.size());
        System.out.println(list.get(0));








    }



}
