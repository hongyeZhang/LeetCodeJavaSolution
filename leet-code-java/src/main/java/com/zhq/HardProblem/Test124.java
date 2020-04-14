package com.zhq.HardProblem;

import com.sun.corba.se.impl.protocol.RequestDispatcherRegistryImpl;

/**
 * @author : ZHQ
 * @date : 2020/4/13
 */
public class Test124 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    int max = Integer.MIN_VALUE;

    /**
     *
     * 先递归计算出单边的最大值（包含该节点，若 left, right 小于 0 则不包含节点下该分支）
     *
     * 该节点下最大值是 left + right + val (若 left, right 小于 0 则不包含节点下该分支)
     *
     * 比较 所有节点下的最大值 所求即为 二叉树中的最大路径和
     *
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    public int maxGain(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);

        int newPathGain = root.val + leftGain + rightGain;
        max = Math.max(max, newPathGain);

        return root.val + Math.max(leftGain, rightGain);
    }






}
