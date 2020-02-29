package algorithm.searching;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-07-16
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101};
        System.out.println(binSearch(a, 0, a.length - 1, 81));
        System.out.println(binSearch(a, 81));
    }

    //二分查找 普通循环实现
    private static int binSearch(int[] a, int key) {
        int mid = a.length / 2;
        if (key == a[mid]) {
            return mid;
        }
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key > a[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    //二分查找递归实现
    private static int binSearch(int[] a, int start, int end, int key) {
        int mid = start + (end - start) / 2;
        if (a[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > a[mid]) {
            return binSearch(a, mid + 1, end, key);
        } else if (key < a[mid]) {
            return binSearch(a, start, mid - 1, key);
        }
        return -1;
    }


}
