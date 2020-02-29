package algorithm.common;

/**
 * @program: data-structure-and-algorithm
 * @description: 0-1背包问题 动态规划
 *   https://blog.csdn.net/xp731574722/article/details/70766804
 *
 *
 * @author: ZHQ
 * @create: 2019-07-28 19:33
 **/
public class Knapsack {
    /**
    * @Description: 一共6个可以选择的物品，背包的容量为12
    **/
    static final int CAPACITY = 12;
    static final int NUM = 6;

    static int[] value = {0, 8, 10, 6, 3, 7, 2};
    static int[] weight = {0, 4, 6, 2, 2, 5, 1};

    /**
    * @Description: 是否拿了该物品，如果拿了，则设定为1，不拿为0
    **/
    static int[] isContains = new int[NUM + 1];

    public static void main(String[] args) {

        // 存储结果的数组，0,0 位置不要
        int[][] valueMatrix = new int[NUM + 1][CAPACITY + 1];
        calculateValue(valueMatrix);

        // 输出
        for (int i = 1; i <= NUM; ++i) {
            for (int j = 1; j <= CAPACITY; ++j) {
                System.out.print(valueMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        // 具体查看包里装的是哪几个物品
        traceBack(valueMatrix, 2);
        for (int i = 1; i <= NUM; ++i) {
            System.out.print(isContains[i] + "\t");
        }
    }


    /**
     * @Description: 声明一个 大小为  m[n][c] 的二维数组，m[ i ][ j ] 表示 在面对第 i 件物品，且背包容量为  j 时所能获得的最大价值 ，那么我们可以很容易分析得出 m[i][j] 的计算方法，
     *
     * （1）. j < w[i] 的情况，这时候背包容量不足以放下第 i 件物品，只能选择不拿
     *
     * m[ i ][ j ] = m[ i-1 ][ j ]
     *
     * （2）. j>=w[i] 的情况，这时背包容量可以放下第 i 件物品，我们就要考虑拿这件物品是否能获取更大的价值。
     *
     * 如果拿取，m[ i ][ j ]=m[ i-1 ][ j-w[ i ] ] + v[ i ]。 这里的m[ i-1 ][ j-w[ i ] ]指的就是考虑了i-1件物品，背包容量为j-w[i]时的最大价值，也是相当于为第i件物品腾出了w[i]的空间。
     *
     * 如果不拿，m[ i ][ j ] = m[ i-1 ][ j ] , 同（1）
     *
     * 究竟是拿还是不拿，自然是比较这两种情况那种价值最大。
     **/
    public static void calculateValue(int[][] matrix) {

        for (int i = 1; i <= NUM; ++i) {
            for (int j = 1; j <= CAPACITY; ++j) {
                if (j >= weight[i]) {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - weight[i]] + value[i]);
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
    }

    /**
     * @Description: m[n][c]为最优值，如果m[n][c]=m[n-1][c] ,说明有没有第n件物品都一样，则x[n]=0 ;
     *              否则 x[n]=1。当x[n]=0时，由x[n-1][c]继续构造最优解；当x[n]=1时，则由x[n-1][c-w[i]]继续构造
     *              最优解。以此类推，可构造出所有的最优解。
     **/
    public static void traceBack(int[][] matrix, int capacity) {
        int tempCap = capacity;
        for (int i = NUM; i > 1; i--) {
            if (matrix[i][tempCap] == matrix[i - 1][tempCap]) {
                isContains[i] = 0;
            } else {
                isContains[i] = 1;
                tempCap -= weight[i];
            }
        }
        isContains[1] = matrix[1][capacity] > 0 ? 1 : 0;
    }

}
