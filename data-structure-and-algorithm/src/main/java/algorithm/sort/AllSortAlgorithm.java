package algorithm.sort;

/**
 * @author : ZHQ
 * @date : 2020/2/29
 */
public class AllSortAlgorithm {

    public static void main(String[] args) {
        int[] inputs = {3, 5, 3, 7, 2, 6, 4, 7, 8};
//        bubbleSort(inputs);
//        quickSort(inputs, 0, inputs.length - 1);
        mergeSort(inputs, 0, inputs.length - 1);

        for (int input : inputs) {
            System.out.print(input + " ");
        }



    }

    /** 冒泡排序
     * @param inputs
     */
    public static void bubbleSort(int[] inputs) {
        int len = inputs.length;
        if (len <= 1) {
            return;
        }
        for (int i = 0; i < len; ++i) {
            boolean quitFlag = true;
            for (int j = 0; j < len - i - 1; ++j) {
                if (inputs[j] > inputs[j + 1]) {
                    int tmp = inputs[j];
                    inputs[j] = inputs[j + 1];
                    inputs[j + 1] = tmp;
                    quitFlag = false;
                }
            }
            if (quitFlag) {
                break;
            }
        }
    }

    /** 快速排序
     * 不稳定
     * @param inputs
     * @param left
     * @param right
     */
    public static void quickSort(int[] inputs, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(inputs, left, right);
        quickSort(inputs, left, partition - 1);
        quickSort(inputs, partition + 1, right);
    }

    public static int partition(int[] inputs, int left, int right) {
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
        // 基准归位
        inputs[left] = pivot;
        return left;
    }

    /** 归并排序
     * 稳定
     * @param inputs
     * @param left
     * @param right
     */
    public static void mergeSort(int[] inputs, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(inputs, left, mid);
        mergeSort(inputs, mid + 1, right);
        merge(inputs, left, mid, right);
    }

    public static void merge(int[] inputs, int left, int mid, int right) {
        int[] tmpArr = new int[right - left + 1];
        int i = 0, p = left, q = mid + 1;
        while (p <= mid && q <= right) {
            tmpArr[i++] = inputs[p] <= inputs[q] ? inputs[p++] : inputs[q++];
        }
        while (p <= mid) {
            tmpArr[i++] = inputs[p++];
        }
        while (q <= right) {
            tmpArr[i++] = inputs[q++];
        }

        // 赋值到原数组
        for (int k = 0; k < tmpArr.length; ++k) {
            inputs[left + k] = tmpArr[k];
        }
    }

}
