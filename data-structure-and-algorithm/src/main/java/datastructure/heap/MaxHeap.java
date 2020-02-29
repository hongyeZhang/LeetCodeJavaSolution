package datastructure.heap;

import com.sun.nio.zipfs.ZipFileAttributes;

import java.io.IOException;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-06-26 00:20
 **/
public class MaxHeap {
    public static void main(String args[]) throws IOException {

        //原始数组内容
        int[] data = {0, 5, 6, 10, 8, 3, 2, 19, 9, 11};

        System.out.print("原始数组：");
        for (int i = 1; i < data.length; i++) {
            System.out.print("[" + data[i] + "] ");
        }

        // 建立堆积树
        MaxHeap.heap(data, data.length);
    }

    public static void heap(int data[], int size) {
        for (int i = (size / 2); i > 0; i--) {
            MaxHeap.ad_heap(data, i, size - 1);
        }

        //建立堆积树节点
        System.out.print("\n大顶堆积：");
        for (int i = 1; i < size; i++) {
            System.out.print("[" + data[i] + "] ");
        }
    }


    /**
     * @Description:  建堆的时间复杂度是O(n)
     * @Param: [data, i, size]
     * @return: void
     * @Author: ZHQ
     * @Date: 2019/7/21
     **/
    public static void ad_heap(int data[], int i, int size) {
        int j, tmp, post;
        j = 2 * i;
        tmp = data[i];
        post = 0;
        while (j <= size && post == 0) {
            if (j < size) {
                //找出两个子节点最大值
                if (data[j] < data[j + 1]) {
                    j++;
                }
            }
            //若树根较大，结束比较过程
            if (tmp >= data[j]) {
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
