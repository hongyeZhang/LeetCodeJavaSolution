package com.zhq.SimpleProblem;

/**
 * @author : ZHQ
 * @date : 2020/4/3
 */
public class Test796 {

    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A+A).contains(B);
    }
}
