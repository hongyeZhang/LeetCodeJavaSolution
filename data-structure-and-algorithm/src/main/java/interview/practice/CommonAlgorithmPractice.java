package interview.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/11
 */
public class CommonAlgorithmPractice {

    /** 全排列
     * @param input
     * @return
     */
    public List<String> allPermutation(String input) {
        List<String> retList = new ArrayList<>();
        allPermutationCore(input.toCharArray(), 0, input.length(), retList);
        return retList;
    }

    public void allPermutationCore(char[] inputArr, int currentIndex, int length,
                    List<String> retList) {
        if (currentIndex == length - 1) {
            retList.add(String.copyValueOf(inputArr));
        } else {
            for (int i = currentIndex; i < length; ++i) {
                swap(inputArr, currentIndex, i);
                allPermutationCore(inputArr, currentIndex + 1, length, retList);
                swap(inputArr, currentIndex, i);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    @Test
    public void testAllPermutation() {
        String input = "abc";
        List<String> list = allPermutation(input);
        for (String s : list) {
            System.out.println(s);
        }

    }


    public void leftOddRightEven(int[] inputArr) {
        if (null == inputArr || inputArr.length < 2) {
            return;
        }

        int left = 0, right = inputArr.length - 1;
        while (left < right) {
            while (left < right && isOdd(inputArr[left])) {
                left++;
            }
            while (left < right && !isOdd(inputArr[right])) {
                right--;
            }
            swap(inputArr, left, right);
        }
    }

    public void swap(int[] inputArr, int i, int j) {
        int tmp = inputArr[i];
        inputArr[i] = inputArr[j];
        inputArr[j] = tmp;
    }

    public boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    @Test
    public void testLeftOddRightEven() {
        int[] nums = new int[] {1, 2, 3, 4, 5, 7, 8, 9};

        leftOddRightEven(nums);

        for (int num : nums) {
            System.out.print(num + "\t");
        }

    }







}
