package com.zhq.MediumProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeTest
 * @description: Z字型变换
 * @author: ZHQ
 * @create: 2019-05-19 21:08
 **/
public class Test6 {

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";

        String str1 = convert(s, 4);
        String str2 = convertZHQ(s, 4);
        System.out.println(str1);
        System.out.println(str2);


    }

    public static String convertZHQ(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int row = Math.min(numRows, s.length());
        boolean downDirectionFlag = true;

        List<StringBuilder> rowContentList = new ArrayList<>();
        for (int i = 0; i < row; ++i) {
            rowContentList.add(new StringBuilder());
        }

        int currentRow = 0;
        for (char c : s.toCharArray()) {
            rowContentList.get(currentRow).append(c);
            if (downDirectionFlag) {
                currentRow++;
            } else {
                currentRow--;
            }
            if (currentRow == 0 || currentRow == row-1) {
                downDirectionFlag = !downDirectionFlag;
            }
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder sb : rowContentList) {
            ret.append(sb.toString());
        }

        return ret.toString();
    }



    /**
     * @Description: 官方解答，确定行数和行进方向即可
     * @Param: [s, numRows]
     * @return: java.lang.String
     * @Author: ZHQ
     * @Date: 2019/5/19
     **/
    public static String convert(String s, int numRows) {


        /*
        * 我们可以使用 min(numRows,len(s))个列表来表示 Z 字形图案中的非空行。

            从左到右迭代 sss，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。

            只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
        * */


        if (numRows == 1){ return s;}

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }


    /**
    * @Description: 直接找规律，通过公式进行相加解答
    * @Param:
    * @return:
    * @Author: ZHQ
    * @Date: 2019/5/19
    **/
    public static String convert2(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
