package algorithm.searching;

/**
 * @program: data-structure-and-algorithm
 * @description: 如何在O(n)时间内，找到一个无序数组的第 K 大元素
 * @author: ZHQ
 * @create: 2019-07-17
 **/
public class FindKthElement {

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 7, 6, 5};
        findK(array, 3);

    }


    /**
     * @Description: 在O(n)时间复杂度里找到一个无序数组的第 k 大元素
     * @Param: [array, k]
     * @return: void
     * @Author: ZHQ
     * @Date: 2019/7/20
     **/
    public static void findK(int[] array, int k) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        method(array, 0, n - 1, k);
    }

    public static void method(int[] array, int l, int r, int k) {
        if (k < l || k > r) {
            throw new IndexOutOfBoundsException("index out of bound");
        }
        if (l > r) {
            return;
        }
        int randomIndex = (int) Math.random() * (r - l + 1) + l;
        swap(array, l, randomIndex);

        int p = partition3(array, l, r);
        if (p > k) {
            method(array, l, p - 1, k);
        } else if (p < k) {
            method(array, p + 1, r, k);
        } else {
            System.out.println(array[p]);
        }
    }

    public static int partition3(int[] array, int l, int r) {
        int val = array[l];
        int j = l;
        int i = l + 1;
        for (; i <= r; i++) {
            if (array[i] < val) {
                swap(array, j + 1, i);
                j++;
            }
        }
        swap(array, l, j);
        return j;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
