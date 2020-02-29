package datastructure.array;

/**
 * @program: data-structure-and-algorithm
 * @description: 固定长度的数组，插入、删除、按照下标随机访问操作；
 * @author: ZHQ
 * @create: 2019-06-19 21:57
 **/
public class Array {
    /**
     * 整型数据data保存数据
     */
    private int[] data;
    /**
     * 数组长度
     */
    private int len;
    /**
     * 实际个数
     */
    private int count;


    public Array(int capacity) {
        data = new int[capacity];
        this.len = capacity;
        this.count = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    public int length() {
        return count;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > len) {
            throw new RuntimeException("array index out of bound");
        }
        if (count == len) {
            throw new RuntimeException("array is full");
        }
        if (index == len) {
            data[len] = value;
            count++;
            return true;
        }

        for (int i = count; i > index; --i) {
            data[i] = data[i-1];
        }
        data[index] = value;
        count++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index > count) {
            throw new RuntimeException("array index out of bound");
        }

        for (int i = index; i < count-1; ++i) {
            data[i] = data[i + 1];
        }
        --count;
        return true;
    }


    public static void main(String[] args) {

        Array arr = new Array(5);
        arr.insert(0, 1);
        arr.insert(0, 3);
        arr.insert(0, 3);

        for (int i = 0; i < arr.length(); ++i) {
            System.out.println(arr.get(i) + "\t");
        }

        arr.delete(0);
        
        for (int i = 0; i < arr.length(); ++i) {
            System.out.println(arr.get(i) + "\t");
        }



    }




}
