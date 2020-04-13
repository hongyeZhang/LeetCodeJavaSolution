package algorithm.total;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author : ZHQ
 * @date : 2020/4/11
 */
public class AllArrayAlgorithm {

    /**
     * 1. 两数之和
     *
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 1) {
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other) != i) {
                return new int[] {map.get(other), i};
            }
        }
        return new int[0];
    }

    @Test
    public void testTwoSum() {
        int[] ints = new int[] {2, 7, 11, 15};
        int[] ints1 = twoSum(ints, 9);

        for (int i : ints1) {
            System.out.print(i + "\t");
        }


    }

}
