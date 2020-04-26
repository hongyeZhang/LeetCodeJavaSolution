package com.zhq.MediumProblem;

/**
 * @author : ZHQ
 * @date : 2020/4/25
 */
public class Test114 {

    static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 将左子树插入到右子树的地方
     * 将原来的右子树接到左子树的最右边节点
     * 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        while (null != root) {
            if (null == root.left) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }


    }





}
