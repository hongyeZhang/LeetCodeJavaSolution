package com.zhq.java.compare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Comparable{
    private String name;
    private int age;

    @Override
    public int compareTo(Object o) {
        Teacher other = (Teacher) o;
        return this.age - other.age;
    }
}
