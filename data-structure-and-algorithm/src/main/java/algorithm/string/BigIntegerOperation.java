package algorithm.string;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/26
 */
public class BigIntegerOperation {

    /**
     *
     * 大数相乘
     * 假设有A和B两个大数，位数分别为a和b。根据我们平常手动计算乘法的方式可以看出，最终的结果的位数c一定小于等于a+b，
     * 我们可以举一个简单的例子来说明，99999=98901，最终结果是五位（a+b）。下面我们根据98765 = 74970来看看结果中的
     * 每一位是怎么得来的，最后一位0是A的最后一位8和B的最后一位5的乘机除10取余得到的，结果的倒数第二位7是A的倒数第二位
     * 9和B的最后一位5的乘积45与A的最后一位8和B的倒数第二位6的乘积48之和93然后加上上一位的进位4得到97然后在除10取余得到的7……
     * 依次进行下去就可以得到最终结果。
     *
     * 下面来总结一下规律：
     *
     * A中的第i位与B的第j位之积最终会存放到结果的第i+j位中（i和j都是从后往前数），所以我们可以先进行结果中每一位的计算，
     * 完成所有计算后在进行进位的计算。为了将i和j从0开始计算，我们先将字符串A和B进行逆转，然后在进行计算的时候就可以从0开始了
     *
     *
     * @param f
     * @param s
     */
    public static void bigNumberSimpleMulti(String f, String s) {
        System.out.print("乘法：\n" + f + "*" + s + "=");
        // 获取首字符，判断是否是符号位
        char signA = f.charAt(0);
        char signB = s.charAt(0);
        char sign = '+';
        if (signA == '+' || signA == '-') {
            sign = signA;
            f = f.substring(1);
        }
        if (signB == '+' || signB == '-') {
            if (sign == signB) {
                sign = '+';
            } else {
                sign = '-';
            }
            s = s.substring(1);
        }
        // 将大数翻转并转换成字符数组
        char[] a = new StringBuilder(f).reverse().toString().toCharArray();
        char[] b = new StringBuilder(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        // 计算最终的最大长度
        int len = lenA + lenB;
        int[] result = new int[len];
        // 计算结果集合
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i + j] += (int) (a[i] - '0') * (int) (b[j] - '0');
            }
        }
        // 处理结果集合，如果是大于10的就向前一位进位，本身进行除10取余
        for (int i = 0; i < result.length; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        // 该字段用于标识是否有前置0，如果是0就不需要打印或者存储下来
        boolean flag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        if (!sb.toString().equals("")) {
            if (sign == '-') {
                sb.insert(0, sign);
            }
        } else {
            sb.append(0);
        }
        // 返回最终结果
        System.out.println(sb.toString());
    }

    @Test
    public void testBigNumberSimpleMulti() {
        String f = "98";
        String s = "765";
        bigNumberSimpleMulti(f, s);
    }


    public String bigNumberAdd(String f, String s) {
        //翻转两个字符串，并转换成数组
        char[] a = new StringBuilder(f).reverse().toString().toCharArray();
        char[] b = new StringBuilder(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        //计算两个长字符串中的较长字符串的长度
        int len = lenA > lenB ? lenA : lenB;
        int[] result = new int[len + 1];
        for (int i = 0; i < len + 1; i++) {
            //如果当前的i超过了其中的一个，就用0代替，和另一个字符数组中的数字相加
            int aint = i < lenA ? (a[i] - '0') : 0;
            int bint = i < lenB ? (b[i] - '0') : 0;
            result[i] = aint + bint;
        }
        //处理结果集合，如果大于10的就向前一位进位，本身进行除10取余
        for (int i = 0; i < result.length; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        //该字段用于标识是否有前置0，如果有就不要存储
        boolean flag = true;
        for (int i = len; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    @Test
    public void testBigNumberAdd() {
        String f = "55";
        String s = "45";
        System.out.println(bigNumberAdd(f, s));
    }


    public static String bigNumberSub(String f, String s) {
//        System.out.print("减法:" + f + "-" + s + "=");
        // 将字符串翻转并转换成字符数组
        char[] a = new StringBuilder(f).reverse().toString().toCharArray();
        char[] b = new StringBuilder(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        // 找到最大长度
        int len = lenA > lenB ? lenA : lenB;
        int[] result = new int[len];
        // 表示结果的正负
        char sign = '+';
        // 判断最终结果的正负
        if (lenA < lenB) {
            sign = '-';
        } else if (lenA == lenB) {
            int i = lenA - 1;
            while (i > 0 && a[i] == b[i]) {
                i--;
            }
            if (a[i] < b[i]) {
                sign = '-';
            }
        }
        // 计算结果集，如果最终结果为正，那么就a-b否则的话就b-a
        for (int i = 0; i < len; i++) {
            int aint = i < lenA ? (a[i] - '0') : 0;
            int bint = i < lenB ? (b[i] - '0') : 0;
            if (sign == '+') {
                result[i] = aint - bint;
            } else {
                result[i] = bint - aint;
            }
        }
        // 如果结果集合中的某一位小于零，那么就向前一位借一，然后将本位加上10。其实就相当于借位做减法
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] < 0) {
                result[i + 1] -= 1;
                result[i] += 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        // 如果最终结果为负值，就将负号放在最前面，正号则不需要
        if (sign == '-') {
            sb.append('-');
        }
        // 判断是否有前置0
        boolean flag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        // 如果最终结果集合中没有值，就说明是两值相等，最终返回0
        if (sb.toString().equals("")) {
            sb.append("0");
        }
        // 返回值
        return sb.toString();
    }

    @Test
    public void testBigNumberSub() {
        String f = "1";
        String s = "100";
        System.out.println(bigNumberSub(f, s));
    }

}
