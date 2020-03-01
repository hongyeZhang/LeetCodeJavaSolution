package com.zhq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : ZHQ
 * @date : 2020/3/1
 */
public class Interview32 {
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

    public static int[] levelOrder(TreeNode root) {
        if (null == root) {
            return new int[0];
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> retList = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            retList.add(node.val);
            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
        }
        int[] ret = new int[retList.size()];
        int i = 0;
        for (Integer integer : retList) {
            ret[i++] = integer;
        }
        return ret;
    }


    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node3 = new TreeNode(3, node9, node20);

        int[] ints = levelOrder(node3);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }



    }
}
