package com.zhq.java.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class Test1 {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("aa", 40);
        Teacher teacher2 = new Teacher("bb", 30);
        Teacher teacher3 = new Teacher("cc", 20);
        List<Teacher> list = new ArrayList<>();
        list.add(teacher1);
        list.add(teacher2);
        list.add(teacher3);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);





    }

    public static void test1() {
        Student student1 = new Student("dd", 40);
        Student student2 = new Student("cc", 30);
        Student student3 = new Student("bb", 20);
        Student student4 = new Student("aa", 10);

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        System.out.println(list);

        list.sort(new StudentComparator());
        System.out.println(list);

    }


}
