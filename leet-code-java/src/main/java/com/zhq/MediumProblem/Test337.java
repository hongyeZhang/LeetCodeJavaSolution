package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jinpeng
 * @date: 2022/4/16 17:35
 */
public class Test337 {

    Map<TreeNode, Integer> memo = new HashMap<>();

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int rob = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int not_rob = rob(root.left) + rob(root.right);
        int res = Math.max(rob, not_rob);
        memo.put(root, res);
        return res;
    }

    @Test
    public void test() {
        System.out.println("test");
    }


}
