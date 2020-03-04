package com.zhq;

/**
 * ref : https://juejin.im/post/5b8d64346fb9a01a1d4f99fa
 * @author : ZHQ
 * @date : 2020/3/4
 */
public class Interview55 {
    public static class TreeNode{
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

    public static void main(String[] args) {

    }


}
