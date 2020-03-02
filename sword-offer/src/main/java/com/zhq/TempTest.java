package com.zhq;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class TempTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        List<Integer> list = new ArrayList<>(stack);

        for (Integer integer : list) {
            System.out.print(integer + "\t");

        }




    }
}
