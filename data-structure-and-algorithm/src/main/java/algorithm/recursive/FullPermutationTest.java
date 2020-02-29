package algorithm.recursive;

/**
 * @program: data-structure-and-algorithm
 * @description: 实现集合的全排列
 * @author: ZHQ
 * @create: 2019-07-07 20:11
 **/
public class FullPermutationTest {
    public static void main(String[] args) {
        int[] input = {1, 3, 5};
        perm(input, 0, input.length - 1);
    }

    static void perm(int[] list, int k, int m) {
        // TODO: 2019/7/7
        if (k == m) {
            for (int i = 0; i < list.length; i++) {
                System.out.print(list[i] + " ");
            }
            System.out.println();
        } else {
            // 进行排列
            for (int i = k; i <= m; i++) {
                //进行交换  从而完成全排列
                int c = list[i];
                list[i] = list[k];
                list[k] = c;
                System.out.println(" k = " + k + " i = " + i);
                perm(list, k + 1, m);
                //需要交换回来 不然就会乱了顺序
                c = list[i];
                list[i] = list[k];
                list[k] = c;
            }
        }
    }

}
