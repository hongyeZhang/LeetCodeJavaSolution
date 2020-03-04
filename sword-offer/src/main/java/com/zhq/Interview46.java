package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/3
 */
public class Interview46 {

    /**
     *  动态规划
     *  f(x) = f(x+1) + f(x+2)  or
     *  f(x) = f(x+1)
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        if (num < 10) {
            return 1;
        }

        String numStr = String.valueOf(num);
        char[] chars = numStr.toCharArray();
        int len = chars.length;
        int[] combineArr = new int[len];


        combineArr[len - 1] = 1;
        int startIndex = len - 2;
        if (isBetween10To25(numStr, startIndex)) {
            combineArr[len - 2] = 2;
        } else {
            combineArr[len - 2] = 1;
        }

        if (len > 2) {
            for (startIndex = len - 3; startIndex >= 0; startIndex--) {
                if (isBetween10To25(numStr, startIndex)) {
                    combineArr[startIndex] = combineArr[startIndex + 1] + combineArr[startIndex + 2];
                } else {
                    combineArr[startIndex] = combineArr[startIndex + 1] ;
                }
            }
        }

        return combineArr[0];
    }

    public static boolean isBetween10To25(String wholeStr, int startIndex) {
        int endIndex = startIndex + 2;
        return isBetween10To25(wholeStr.substring(startIndex, endIndex));
    }

    public static boolean isBetween10To25(String input) {
        if ((input.compareTo("10") > -1) && ((input.compareTo("25") < 1))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        int input = 12258;
        int input = 11;
        System.out.println(translateNum(input));

    }
}
