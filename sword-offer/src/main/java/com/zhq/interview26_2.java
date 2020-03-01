package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class interview26_2 {
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
        // leetcode 上用来解决一个边界用例的，感觉不对
        if (B == null) {
            return false;
        }
        return searchRoot(A, B);
    }

    // 首先找到尽所有可能开始的根节点,然后从该根节点开始找是不是子树，如果是直接结束，不是就看A的子数其他的节点
    public static boolean searchRoot(TreeNode a, TreeNode b){
        if (a != null && b == null) {
            return true;
        } else if (a == null && b == null) {
            return true;
        } else if (a == null && b != null) {
            return false;
        } else {
            if (b.val == a.val) {
                if (isSub(a, b)) {
                    return true;
                }
            }
            return searchRoot(a.left, b) || searchRoot(a.right, b);
        }
    }

    // 判断当前根节点开始，左右子树是否相等
    public static boolean isSub(TreeNode a, TreeNode b){
        if (a == null && b == null) {
            return true;
        } else if (a != null && b == null) {
            return true;
        } else if (a == null && b != null) {
            return false;
        } else {
            return a.val == b.val && (isSub(a.left, b.left) && isSub(a.right, b.right));
        }
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
