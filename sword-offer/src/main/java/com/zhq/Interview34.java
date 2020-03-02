package com.zhq;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/3/2
 */
public class Interview34 {
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


    public static List<List<Integer>> retList = new ArrayList<>();

    public static Stack<Integer> path = new Stack<>();

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (null == root) {
            return new ArrayList<>(0);
        }
        findPath(root, sum, 0);
        return retList;
    }

    public static void findPath(TreeNode node, int expectedSum, int currentSum) {
        if (null == node) {
            return;
        }

        currentSum += node.val;
        path.push(node.val);

        if (currentSum == expectedSum && isLeafNode(node)) {
            addStackToList();
            path.pop();
            return;
        } else if (isLeafNode(node)) {
            path.pop();
            return;
        }

        findPath(node.left, expectedSum, currentSum);
        findPath(node.right, expectedSum, currentSum);
        path.pop();
    }

    public static boolean isLeafNode(TreeNode node) {
        return (null == node.left) && (null == node.right);
    }

    public static void addStackToList() {
        retList.add(new ArrayList<>(path));
    }




    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node11 = new TreeNode(11, node7, node2);
        TreeNode node13 = new TreeNode(13, null, null);
        TreeNode node4 = new TreeNode(4, node5, node1);
        TreeNode node8 = new TreeNode(8, node13, node4);
        TreeNode node4_1 = new TreeNode(4, node11, null);
        TreeNode node5_1 = new TreeNode(5, node4_1, node8);

        List<List<Integer>> lists = pathSum(node5_1, 22);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }



    }

}
