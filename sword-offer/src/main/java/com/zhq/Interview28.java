package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class Interview28 {
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

    /** 判断二叉树是否对称
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return isSymmetricCore(root, root);
    }

    public static boolean isSymmetricCore(TreeNode node1, TreeNode node2) {
        if (null == node1 && null == node2) {
            return true;
        }
        if (null == node1 || null == node2) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSymmetricCore(node1.left, node2.right) && isSymmetricCore(node1.right, node2.left);
    }

    public static void main(String[] args) {

    }


}
