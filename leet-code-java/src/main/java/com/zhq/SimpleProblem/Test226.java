package com.zhq.SimpleProblem;


import org.junit.Test;

public class Test226 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void preTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        preTraverse(root.left);
        preTraverse(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node9 = new TreeNode(9, null, null);

        TreeNode node2 = new TreeNode(2, node3, node1);
        TreeNode node7 = new TreeNode(7, node9, node6);

        TreeNode node4 = new TreeNode(4, node7, node2);

        preTraverse(node4);

    }

}
