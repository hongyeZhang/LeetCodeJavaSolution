package algorithm.string;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-07-20 16:20
 **/
public class StringMatch {

    public static void main(String[] args) {

        String parentStr = "eeeabeeeabc";
        String subStr = "abc";
        System.out.println(violateMatch(parentStr, subStr));


    }

    /**
     * @Description: 暴力匹配法
     * 假设现在我们面临这样一个问题：有一个文本串S，和一个模式串P，现在要查找P在S中的位置，怎么查找呢？
     * 如果用暴力匹配的思路，并假设现在文本串S匹配到 i 位置，模式串P匹配到 j 位置，则有：
     * 如果当前字符匹配成功（即S[i] == P[j]），则i++，j++，继续匹配下一个字符；
     * 如果失配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0。相当于每次匹配失败时，i 回溯，j 被置为0。
     * @Param: [str, subStr]
     * @return: int
     * @Author: ZHQ
     * @Date: 2019/7/20
     **/
    public static int violateMatch(String str, String subStr) {
        int length = str.length();
        int subLength = subStr.length();
        int index = 0;
        int subIndex = 0;

        while (index < length && subIndex < subLength) {
            if (str.charAt(index) == subStr.charAt(subIndex)) {
                index++;
                subIndex++;
            } else {
                subIndex = 0;
                index = index - subIndex + 1;
            }
        }

        if (subIndex == subLength) {
            return index - subLength;
        }
        return -1;
    }

    /**
     * @Description: https://blog.csdn.net/v_july_v/article/details/7041827
     *               这篇博文讲的很好
     * @Param: [str, subStr]
     * @return: void
     * @Author: ZHQ
     * @Date: 2019/7/20
     **/
    public static void KMPSearch(String str, String subStr) {

    }


}
