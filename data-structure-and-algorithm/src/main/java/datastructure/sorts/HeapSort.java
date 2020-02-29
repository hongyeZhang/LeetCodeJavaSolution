package datastructure.sorts;

/**
 * @program: data-structure-and-algorithm
 * @description: 堆排序算法
 * （1） 构造一个大顶堆，从最后一个非叶节点开始调整
 * （2） 构造好初始堆之后，将堆头元素交换到堆尾，堆尾的元素就已经是有序的了，然后一直重复，直到所有都有序。
 * @author: ZHQ
 * @create: 2019-07-16 21:55
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {16, 7, 3, 20, 17, 8};
        headSort(nums);
    }

    /**
     * 堆排序
     */
    public static void headSort(int[] list) {
        // 构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = (list.length) / 2 - 1; i >= 0; i--) {
            headAdjust(list, list.length, i);
        }
        System.out.println("构造堆的结果");
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            headAdjust(list, i, 0);
        }

        System.out.println("排序结果");
        for (int num : list) {
            System.out.print(num + " ");
        }
    }

    private static void headAdjust(int[] list, int len, int i) {
        int k = i, temp = list[i], index = 2 * k + 1;
        while (index < len) {
            if (index + 1 < len) {
                if (list[index] < list[index + 1]) {
                    index = index + 1;
                }
            }
            if (list[index] > temp) {
                list[k] = list[index];
                k = index;
                index = 2 * k + 1;
            } else {
                break;
            }
        }
        list[k] = temp;
    }
}
