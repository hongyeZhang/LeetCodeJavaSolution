package com.zhq.HardProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeTest
 * @description:
 * @author: ZHQ
 * @create: 2019-06-15
 **/
public class TempTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        System.out.println(list);
        List<String> subList = list.subList(1, list.size());
        System.out.println(subList);



    }


}
