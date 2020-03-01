package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class Interview26 {
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

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        if (A != null && B != null) {
            if (A.val == B.val) {
                result = doesAContainsB(A, B);
            }
            if (!result) {
                result = isSubStructure(A.left, B);
            }
            if (!result) {
                result = isSubStructure(A.right, B);
            }
        }

        return result;
    }

    public static boolean doesAContainsB(TreeNode A, TreeNode B) {
        if (A == null) {
            return false;
        }
        if (B == null) {
            return true;
        }
        if (A.val != B.val) {
            return false;
        }
        return doesAContainsB(A.left, B.left) && doesAContainsB(A.right, B.right);
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node4 = new TreeNode(4, node1, node2);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node3 = new TreeNode(3, node4, node5);

        TreeNode B1 = new TreeNode(1, null, null);
        TreeNode B4 = new TreeNode(4, B1, null);

        System.out.println(isSubStructure(node3, B4));



    }


}
