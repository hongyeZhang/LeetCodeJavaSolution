package com.zhq.java.compare;

import java.util.Comparator;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }

}
