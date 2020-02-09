package com.zhq.MediumProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class Test60_1 {

    /**
     * 参考别人的：将 n! 种排列分为：n 组，每组有 (n - 1)!个排列，根据k值可以确定是第几组的第几个排列，选取该排列的第1个数字，然后递归从剩余的数字里面选取下一个数字，直到n=1为止。
     *
     * 作者：zhuanglee
     * 链接：https://leetcode-cn.com/problems/permutation-sequence/solution/zhi-xing-yong-shi-1-ms-zai-suo-you-java-ti-jiao-54/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        // 将 n! 种排列分为：n 组，每组有 (n - 1)! 种排列
        return recursive(n, factorial(n - 1), k, visited);
    }

    /**
     * @param n 剩余的数字个数，递减
     * @param f 每组的排列个数
     */
    private String recursive(int n, int f, int k, boolean[] visited) {
        int offset = k % f;// 组内偏移量
        int groupIndex = k / f + (offset > 0 ? 1 : 0);// 第几组
        // 在没有被访问的数字里找第 groupIndex 个数字
        int i = 0;
        for (; i < visited.length && groupIndex > 0; i++) {
            if (!visited[i]) {
                groupIndex--;
            }
        }
        visited[i - 1] = true;// 标记为已访问
        if (n - 1 > 0) {
            // offset = 0 时，则取第 i 组的第 f 个排列，否则取第 i 组的第 offset 个排列
            return String.valueOf(i) + recursive(n - 1, f / (n - 1), offset == 0 ? f : offset, visited);
        } else {
            // 最后一数字
            return String.valueOf(i);
        }
    }

    /**
     * 求 n!
     */
    private int factorial(int n) {
        int res = 1;
        for (int i = n; i > 1; i--) {
            res *= i;
        }
        return res;
    }


}
