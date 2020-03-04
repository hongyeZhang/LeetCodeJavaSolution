package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/4
 */
public class Interview55_2 {
    public static class TreeNode {
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


    public static boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isBalancedCore(root);

    }

    public static boolean isBalancedCore(TreeNode node) {
        if (node == null) {
            return true;
        }
        int leftDepth = getTreeDepth(node.left);
        int rightDepth = getTreeDepth(node.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalancedCore(node.left) && isBalancedCore(node.right);
    }

    public static int getTreeDepth(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return Math.max(getTreeDepth(node.left), getTreeDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node3 = new TreeNode(3, node9, node20);

        System.out.println(isBalanced(node3));

    }








}
