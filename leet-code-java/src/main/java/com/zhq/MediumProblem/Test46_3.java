package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author ZHQ
 * @date 2022/2/28
 */
public class Test46_3 {

    /**
     * 深度优先遍历的做法
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return Collections.emptyList();
        }
        int len = nums.length;
        List<List<Integer>> retList = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[len];
        dfs(retList, nums, path,  used);
        return retList;
    }

    /**
     * 从 0 开始遍历，由于会访问到之前已经用到的元素，因此需要 used 数组进行记录
     * @param retList
     * @param nums
     * @param path
     * @param used
     */
    public void dfs(List<List<Integer>> retList, int[] nums, Stack<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            retList.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            }
            path.push(nums[i]);
            used[i] = true;
            dfs(retList, nums, path, used);
            path.pop();
            used[i] = false;
        }
    }


    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> retList = permute(nums);
        for (List<Integer> integers : retList) {
            System.out.println(integers);
        }

    }
}
