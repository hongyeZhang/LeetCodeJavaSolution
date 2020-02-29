package algorithm.common;

/**
 * @program: data-structure-and-algorithm
 * @description: 给定一个数组A，A存有n个互不相同的整数。定义：若i<j且A[i]>A[j],则称(i,j)为A的一个逆序对(inversation)
 * @author: ZHQ
 * @create: 2019-07-28 20:09
 **/

/**
 * 数组中的逆序对：数组中任意的两个数字，如果前一个数字大于后一个数字，则这两个数字就构成了一个逆序对。
 */
public class InverseParisInArray {

    /**
     * 求指定数组中，逆序对的个数。
     */
    public static int getInverseParisCountByMergeSort(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("invalid input");
        }

        // 存储逆序对个数的容器
        int[] countContainer = new int[1];

        mergeSort(array, 0, array.length - 1, countContainer);
        return countContainer[0];
    }


    /**
     * 求指定数组中，逆序对的个数。
     * <p>
     * 思路：
     * 1)把数组分隔成两个子数组A和B，先统计出子数组中逆序对的个数 并且 将子数组进行排序，然后再统计出这两个子数组之间的逆序对的个数。
     * 2)排序的目的是为了避免在之后的统计中出现重复统计。
     * 3)在对子数组进行统计时，仍然将数组分为两个子数组，故这里使用递归来实现该功能。
     * <p>
     * 时间复杂度：O(nlogn)
     *
     * @param array
     * @param low
     * @param high
     * @param countContainer
     * @return
     */
    public static void mergeSort(int[] array, int low, int high, int[] countContainer) {
        if (low < high) {
            // 当low=high时，说明已经分解到单个元素了
            int mid = (low + high) >> 1;
            // 递归地对左半部分进行分解
            mergeSort(array, low, mid, countContainer);
            // 递归地对右半部分进行分解
            mergeSort(array, mid + 1, high, countContainer);
            // 分解已完成，将左子序列和右子序列进行合并
            merge(array, low, mid, high, countContainer);
        }
    }


    public static void merge(int[] array, int low, int mid, int high, int[] countContainer) {

        // 临时数组，长度与原数组长度一致
        int[] temp = new int[high - low + 1];

        // 左边序列的最后一个元素的下标
        int i = mid;
        // 右边序列的最后一个元素的下标
        int j = high;
        // 临时数组temp的下标
        int k = temp.length - 1;

        /**
         * 把较大的数先copy到临时数组temp中：
         */
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                temp[k--] = array[i--];
                countContainer[0] += j - mid;
            } else {
                temp[k--] = array[j--];
            }
        }

        // 如果左边的序列中还有未copy过的元素，则把左边剩余的元素copy临时数组temp中。
        while (i >= low) {
            temp[k--] = array[i--];
        }

        // 如果右边的序列中还有未copy过的元素，则把右边剩余的元素copy临时数组temp中。
        while (j > mid) {
            temp[k--] = array[j--];
        }

        // 用排好序的临时数组temp覆盖原数组
        for (int t = 0; t < temp.length; t++) {
            array[t + low] = temp[t];
        }
    }


    public static void main(String[] args) {

        int[] array = {7, 6, 5, 4};
//        int[] array = {7, 5, 6, 4};
//        int[] array = {4, 5, 6, 7};
        int count = getInverseParisCountByMergeSort(array);
        System.out.println(count);

    }

}
