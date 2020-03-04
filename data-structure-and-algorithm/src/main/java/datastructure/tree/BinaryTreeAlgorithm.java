package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ref : https://juejin.im/post/5b8d64346fb9a01a1d4f99fa
 * @author : ZHQ
 * @date : 2020/3/4
 */
public class BinaryTreeAlgorithm {
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

    /** 求二叉树的最大深度（即求根节点的深度）
     * =============================================================================================
     * @param node
     * @return
     */
    public static int maxDepth(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }


    /** 二叉树的所有路径
     * =============================================================================================
     * @param root
     * @return
     */
    public static List<List<Integer>> allPaths(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> allPathList = new ArrayList<>();
        List<Integer> currentPathList = new ArrayList<>();

        currentPathList.add(root.val);
        allPathCore(root, allPathList, currentPathList);

        for (List<Integer> list : allPathList) {
            for (Integer integer : list) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
        return allPathList;
    }

    public static void allPathCore(TreeNode node, List<List<Integer>> allPathList,
                    List<Integer> currentPathList) {
        if (null == node.left && null == node.right) {
            allPathList.add(currentPathList);
        }

        if (null != node.left) {
            List<Integer> tmpList = new ArrayList<>(currentPathList);
            tmpList.add(node.left.val);
            allPathCore(node.left, allPathList, tmpList);
        }

        if (null != node.right) {
            List<Integer> tmpList = new ArrayList<>(currentPathList);
            tmpList.add(node.right.val);
            allPathCore(node.right, allPathList, tmpList);
        }
    }


    /** 判断是否为AVL树， 是否平衡
     * =============================================================================================
     * @param root
     * @return
     */
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

    /**
     * 通过计算高度，更改flag
     */
    public static class AVLTreeSoultion2{
        boolean flag = true;
        public boolean isBalanced(TreeNode root) {
            if(root==null){
                return true;
            }
            height(root);
            return flag;
        }

        private int height(TreeNode root){
            if(root==null){
                return 0;
            }
            int left = height(root.left);
            int right = height(root.right);
            if(Math.abs(left-right)>1){
                flag = false;
            }
            return 1+Math.max(left, right);
        }
    }











}
