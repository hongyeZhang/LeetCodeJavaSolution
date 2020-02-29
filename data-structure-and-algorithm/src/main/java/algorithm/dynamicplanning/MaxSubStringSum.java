package algorithm.dynamicplanning;

/**
 * @program: data-structure-and-algorithm
 * @description:  最大子序列和
 * 找最大子序列的方法很简单，只要前i项的和还没有小于0那么子序列就一直向后扩展，否则丢弃之前的子序列开始新的子序列，
 * 同时我们要记下各个子序列的和，最后找到和最大的子序列。
 * @author: ZHQ
 * @create: 2019-07-28 23:06
 **/
public class MaxSubStringSum {



    public static void main(String[] args) {
        int[] input = {5, -3, 4, 2};
        int[] input2 = {5,-6,4,2};

        outputMaxSubSequence(input2);
    }

    public static void outputMaxSubSequence(int[] arr) {
        int sum = 0;
        int currSum = 0;
        int begin = 0;
        int end = 0;
        int newBegin = 0;

        for (int i = 0; i < arr.length; ++i) {
            currSum += arr[i];
            if (currSum > sum) {
                sum = currSum;
                begin = newBegin;
                end = i;
            }
            if (currSum < 0) {
                currSum = 0;
                newBegin = i + 1;
            }
        }

        System.out.println("最大子序列的和为 : " + sum);
        System.out.println("最大子序列为 :");
        for (int i = begin; i <= end; ++i) {
            System.out.print(arr[i] + "\t");
        }
    }
}
