package com.zhq.SimpleProblem;

/**
 * @author : ZHQ
 * @date : 2020/2/8
 */
public class Test53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArrayMethod2(nums));
        System.out.println(maxSubArrayMethod3(nums));


    }




    /**
     *  贪心算法
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        // 当前元素位置的最大和
        int currSum = nums[0];
        // 迄今为止的最大和
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    /**
     * 当前最大连续子序列和为 sum，结果为 ans
     * 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
     * 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
     * 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int maxSubArrayMethod2(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;

    }

    /**
     * 动态规划
     * 在整个数组或在固定大小的滑动窗口中找到总和或最大值或最小值的问题可以通过动态规划（DP）在线性时间内解决。
     * 有两种标准 DP 方法适用于数组：
     * 常数空间，沿数组移动并在原数组修改。
     * 线性空间，首先沿 left->right 方向移动，然后再沿 right->left 方向移动。 合并结果。
     * 我们在这里使用第一种方法，因为可以修改数组跟踪当前位置的最大和。
     * 下一步是在知道当前位置的最大和后更新全局最大和。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int maxSubArrayMethod3(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }

}
