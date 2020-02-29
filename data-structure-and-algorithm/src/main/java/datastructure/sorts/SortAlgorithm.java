package datastructure.sorts;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-06-21 19:52
 **/
public class SortAlgorithm {

    public static void main(String[] args) {
        int[] inputs = {3, 5, 3, 7, 2, 6, 4, 7, 8};

//        bubbleSort(inputs, inputs.length);
//        bubbleSort2(inputs, inputs.length);
//        insertionSort(inputs, inputs.length);
//        selectionSort(inputs, inputs.length);
//        quickSort(inputs, 0, inputs.length - 1);
//        mergeSort(inputs, 0, inputs.length - 1);
        shellSort(inputs, inputs.length);

        for (int i = 0; i < inputs.length; ++i) {
            System.out.print(inputs[i] + " ");
        }
    }

    /**
     * 冒泡排序：
     * (1)比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * (2)对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * (3)针对所有的元素重复以上的步骤，除了最后一个。
     * (4)持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; ++i) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }


    /**
     * 冒泡排序改进:
     * 在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     */
    public static void bubbleSort2(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag) break;    // 没有数据交换，提前退出
        }

    }


    /**
     * 插入排序：
     * （1）插入排序的基本方法是：每步将一个待排序的元素，按其排序码大小插入到前面已经排好序的一组元素的适当位置上去，直到元素全部插入为止。
     * （2）可以选择不同的方法在已经排好序的有序数据表中寻找插入位置，依据查找方法的不同，有多种插入排序方法。下面是常用的三种。
     * 1>  直接插入排序
     * 2>  折半插入排序
     * 3>  希尔排序
     * =============================================================================================
     * 直接插入排序：
     * 从待排序列中选出一个元素，插入到已经有序的元素之中，直到所有的元素都插入到有序序列中
     * 通常的做法就是将第一个元素看做是有序的元素（即待排序列的第一个元素看做是有序序列），然后我们将第二个元素和有序序列（即
     * 第一个元素）作比较，按正确的序列插入到序列中去。然后在将第三个元素和前面有序序列（即整个待排序列的前两个元素）作比较，将第
     * 三个插入到前两个元素中去，使得前三个元素有序。以此类推，直到所有的元素都有序。
     */
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找要插入的位置并移动数据
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }


    /**
     * 希尔排序： 不稳定的排序算法
     * 希尔排序（shell sort）这个排序方法又称为缩小增量排序，是1959年D·L·Shell提出来的。该方法的基本思想是：
     * 设待排序元素序列有n个元素，首先取一个整数increment（小于n）作为间隔将全部元素分为increment个子序列，
     * 所有距离为increment的元素放在同一个子序列中，在每一个子序列中分别实行直接插入排序。然后缩小间隔increment，
     * 重复上述子序列划分和排序工作。直到最后取increment=1，将所有元素放在同一个子序列中排序为止。
     * （2）由于开始时，increment的取值较大，每个子序列中的元素较少，排序速度较快，到排序后期increment取值逐渐变小，
     * 子序列中元素个数逐渐增多，但由于前面工作的基础，大多数元素已经基本有序，所以排序速度仍然很快。
     */
    public static void shellSort(int[] a, int n) {
        int d = n;
        while (d != 0) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                // 分的组数
                for (int i = x + d; i < a.length; i += d) {
                    // 组中的元素，从第二个数开始
                    // j为有序序列最后一位的位数
                    int j = i - d;
                    // 要插入的元素
                    int temp = a[i];
                    // 从后往前遍历。
                    for (; j >= 0 && temp < a[j]; j -= d) {
                        // 向后移动d位
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
        }
    }


    /**
     * 选择排序：
     * 每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕。
     * 也就是：每一趟在n-i+1(i=1，2，…n-1)个记录中选取关键字最小的记录作为有序序列中第i个记录。
     * 基于此思想的算法主要有简单选择排序、树型选择排序和堆排序。
     */
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
    }


    /**
     * 快速排序：
     * 快速排序是冒泡排序的改进版，也是最好的一种内排序，在很多面试题中都会出现，也是作为程序员必须掌握的一种排序方法。
     * 1.在待排序的元素任取一个元素作为基准(通常选第一个元素，但最的选择方法是从待排序元素中随机选取一个作为基准)，称为基准元素；
     * 2.将待排序的元素进行分区，比基准元素大的元素放在它的右边，比其小的放在它的左边；
     * 3.对左右两个分区重复以上步骤直到所有元素都是有序的。
     * 可以把快速排序联想成东拆西补或西拆东补，一边拆一边补，直到所有元素达到有序状态。
     */
    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(a, left, right);
        quickSort(a, left, index - 1);
        quickSort(a, index + 1, right);
    }

    public static int partition(int[] a, int left, int right) {
        int temp = a[left];
        while (left < right) {
            // 从右边往左扫描
            while (left < right && a[right] >= temp) {
                right--;
            }
            a[left] = a[right];
            // 从左往右扫描
            while (left < right && a[left] <= temp) {
                left++;
            }
            a[right] = a[left];
        }
        // 基准元素归位
        a[left] = temp;

        return left;
    }


    /**
     * 归并排序：
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(N)，归并排序需要一个与原数组相同长度的数组做辅助来排序
     * 稳定性：稳定
     */
    public static void mergeSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    public static void merge(int[] a, int left, int mid, int right) {
        // 第一个序列[left, mid], 第二个序列[mid+1, right]，先将归并结果放到一个临时数组中
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p = left;
        int q = mid + 1;
        // 比较左右两部分的元素，将较小的元素填入temp
        while (p <= mid && q <= right) {
            temp[i++] = a[p] <= a[q] ? a[p++] : a[q++];
        }
        while (p <= mid) {
            temp[i++] = a[p++];
        }
        while (q <= right) {
            temp[i++] = a[q++];
        }

        // 把最终的排序的结果复制给原数组
        for (int k = 0; k < temp.length; ++k) {
            a[left + k] = temp[k];
        }

    }


}
