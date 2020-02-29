package algorithm.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: data-structure-and-algorithm
 * @description: 求字符串的全排列，按照字典顺序输出
 *  解释: https://blog.csdn.net/Strom72/article/details/80738818
 * @author: ZHQ
 * @create: 2019-08-10 21:53
 **/
public class StringAllPermutation {

    public static void main(String[] args) {
        String input = "abc";
        List<String> ret = calcAllPermutation(input);
        for (String s : ret) {
            System.out.println(s);
        }
    }

    private static List<String> calcAllPermutation(String input) {
        List<String> ret = new ArrayList<>();
        char[] charArr = input.toCharArray();
        help(0, charArr, ret);
        Collections.sort(ret);
        return ret;
    }

    private static void help(int index, char[] charArr, List<String> ret) {
        if (index == charArr.length - 1) {
            String ans = String.valueOf(charArr);
            if (!ret.contains(ans)) {
                ret.add(ans);
            }
        } else {
            for (int i = index; i < charArr.length; ++i) {
                swap(charArr, index, i);
                help(index + 1, charArr, ret);
                swap(charArr, i, index);
            }
        }
    }

    private static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
