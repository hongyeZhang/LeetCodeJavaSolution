package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class Interview31 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (null == pushed && null == popped) {
            return true;
        }
        if (null == pushed || null == popped || pushed.length != popped.length) {
            return false;
        }
        int len = pushed.length;
        int pushIndex = 0, popIndex = len - 1;
        while (pushIndex < len && popIndex >= 0) {
            if (pushed[pushIndex] != popped[popIndex]) {
                return false;
            }
            popIndex--;
            pushIndex++;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] pushed = new int[] {1, 2, 3, 4, 5};
        int[] popped = new int[] {5, 4, 3, 2, 1};
        System.out.println(validateStackSequences((pushed), popped));
    }
}
