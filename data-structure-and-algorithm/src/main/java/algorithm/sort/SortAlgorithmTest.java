package algorithm.sort;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/4/7
 */
public class SortAlgorithmTest {


    /** 快速排序
     * @param inputs
     */
    public void quickSort(int[] inputs) {
        if (inputs.length < 2) {
            return;
        }
        quickSortCore(inputs, 0, inputs.length - 1);
    }

    public void quickSortCore(int[] inputs, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = quickSortPartition(inputs, left, right);
        quickSortCore(inputs, left, mid - 1);
        quickSortCore(inputs, mid + 1, right);
    }

    public int quickSortPartition(int[] inputs, int left, int right) {
        int pivot = inputs[left];
        while (left < right) {
            while (left < right && inputs[right] >= pivot) {
                right--;
            }
            inputs[left] = inputs[right];
            while (left < right && inputs[left] < pivot) {
                left++;
            }
            inputs[right] = inputs[left];
        }
        inputs[left] = pivot;
        return left;
    }

    @Test
    public void testQuickSort() {
        int[] inputs = {3, 5, 3, 7, 2, 6, 4, 7, 8};
        System.out.println("original array : ");
        for (int input : inputs) {
            System.out.print(input + "\t");
        }
        System.out.println();

        quickSort(inputs);

        System.out.println("after sort : ");
        for (int input : inputs) {
            System.out.print(input + "\t");
        }
    }


    /** 归并排序
     * @param inputs
     */
    public void mergeSort(int[] inputs) {
        if (inputs.length < 2) {
            return;
        }
        mergeSortCore(inputs, 0, inputs.length - 1);
    }

    public void mergeSortCore(int[] inputs, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSortCore(inputs, left, mid);
        mergeSortCore(inputs, mid + 1, right);
        mergeCore(inputs, left, mid, right);
    }

    public void mergeCore(int[] inputs, int left, int mid, int right) {
        int[] tmpArr = new int[right - left + 1];
        int i = 0, p = left, q = mid + 1;
        while (p <= mid || q <= right) {
            while (p <= mid && q <= right) {
                tmpArr[i++] = inputs[p] <= inputs[q] ? inputs[p++] : inputs[q++];
            }
            while (p <= mid) {
                tmpArr[i++] = inputs[p++];
            }
            while (q <= right) {
                tmpArr[i++] = inputs[q++];
            }
        }

        for (int k = 0; k < tmpArr.length; ++k) {
            inputs[left + k] = tmpArr[k];
        }
    }

    @Test
    public void testMergeSort() {
        int[] inputs = {3, 5, 3, 7, 2, 6, 4, 7, 8};
        System.out.println("original array : ");
        for (int input : inputs) {
            System.out.print(input + "\t");
        }
        System.out.println();

        mergeSort(inputs);

        System.out.println("after sort : ");
        for (int input : inputs) {
            System.out.print(input + "\t");
        }
    }

}
