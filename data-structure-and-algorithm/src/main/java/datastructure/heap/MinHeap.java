package datastructure.heap;

import java.io.IOException;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-07-15 23:35
 **/
public class MinHeap {

    public static void main(String args[]) throws IOException {

        int[] data = {0, 5, 6, 10, 8, 3, 2, 19, 9, 11};

        System.out.print("初始数组：");
        for (int i = 1; i < data.length; i++) {
            System.out.print("[" + data[i] + "] ");
        }

        MinHeap.heap(data, data.length);
    }

    public static void heap(int data[], int size) {
        for (int i = (size / 2); i > 0; i--) {
            MinHeap.ad_heap(data, i, size - 1);
        }

        //建立堆积树节点
        System.out.print("\n小顶堆积：");
        for (int i = 1; i < size; i++) {
            System.out.print("[" + data[i] + "] ");
        }
    }

    public static void ad_heap(int data[], int i, int size) {
        int j, tmp, post;
        j = 2 * i;
        tmp = data[i];
        post = 0;
        while (j <= size && post == 0) {
            if (j < size) {
                if (data[j] > data[j + 1]) {
                    j++;
                }
            }
            if (tmp <= data[j]) {
                post = 1;
            } else {
                //若树根较小，则继续比较，这里将最大子节点赋值给父节点
                data[j / 2] = data[j];
                j = 2 * j;
            }
        }

        //指定树根为父节点
        data[j / 2] = tmp;
    }


}
