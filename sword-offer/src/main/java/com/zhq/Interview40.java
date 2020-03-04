package com.zhq;

import java.util.Arrays;

/**
 * @author : ZHQ
 * @date : 2020/3/3
 */
public class Interview40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = arr[i];
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
