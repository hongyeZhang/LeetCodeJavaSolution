package algorithm.recursive;

import sun.awt.geom.AreaOp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/3/3
 */
public class FullPermutationTest2 {

    public static void fullPermutation(int[] input, int index, int length,
                    List<List<Integer>> retList) {
        if (index == length - 1) {
            List<Integer> tmpList = new ArrayList<>();
            for (int i : input) {
                tmpList.add(i);
            }
            retList.add(tmpList);
        } else {
            for (int i = index; i < length; ++i) {
                swap(input, index, i);
                fullPermutation(input, index + 1, length, retList);
                swap(input, index, i);
            }
        }
    }

    public static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
    
    
    



    public static void main(String[] args) {
        int[] input = {1, 3, 5};

        List<List<Integer>> retList = new ArrayList<>();
        fullPermutation(input, 0, input.length, retList);

        for (List<Integer> list : retList) {
            for (Integer integer : list) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }

    }
    
    
    
    
    
    
}
