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

    public static void perm(int[] list, int k, int m) {
        if (k == m) {
            for (int i = 0; i < list.length; i++) {
                System.out.print(list[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = k; i <= m; i++) {
                swap(list, i, k);
                perm(list, k + 1, m);
                swap(list, i, k);
            }
        }
    }

    public static void swap(int[] list, int i, int j) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }


}
