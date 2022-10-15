package algorithm.recursive;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/3/3
 */
public class FullPermutationTest {

    @Test
    public void testFullPermutation() {
        int[] input = {1, 3, 5};
        List<List<Integer>> retList = new ArrayList<>();
        fullPermutation(input, 0, retList);

        for (List<Integer> list : retList) {
            for (Integer integer : list) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }


    @Test
    public void test2() {

        int[] input = {1, 3, 5};
        List<List<Integer>> retList = new ArrayList<>();
        boolean[] chooseFlag = new boolean[input.length];
        fullPermutationSecond(input, 0, chooseFlag, retList);

        for (List<Integer> list : retList) {
            for (Integer integer : list) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

    public static void fullPermutationSecond(int[] input, int index, boolean[] chooseFlag, List<List<Integer>> retList) {
        if (index == input.length) {

        }
    }



    public static void fullPermutation(int[] input, int index, List<List<Integer>> retList) {
        if (index == input.length - 1) {
            List<Integer> tmpList = new ArrayList<>();
            for (int i : input) {
                tmpList.add(i);
            }
            retList.add(tmpList);
        } else {
            for (int i = index; i < input.length; ++i) {
                swap(input, index, i);
                fullPermutation(input, index + 1, retList);
                swap(input, index, i);
            }
        }
    }

    public static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    
}
