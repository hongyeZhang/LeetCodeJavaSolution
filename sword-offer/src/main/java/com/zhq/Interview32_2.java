package com.zhq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/3/2
 */
public class Interview32_2 {
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> retList = new ArrayList<>();
        int nextLevel = 0;
        int toBePrinted = 1;
        queue.offer(root);
        List<Integer> levelList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelList.add(node.val);
            toBePrinted--;

            if (null != node.left) {
                queue.offer(node.left);
                nextLevel++;
            }
            if (null != node.right) {
                queue.offer(node.right);
                nextLevel++;
            }
            if (toBePrinted == 0) {
                retList.add(levelList);
                levelList = new ArrayList<>();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return retList;
    }


    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node3 = new TreeNode(3, node9, node20);

        List<List<Integer>> lists = levelOrder(node3);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }



    }

}
