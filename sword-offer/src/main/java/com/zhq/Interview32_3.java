package com.zhq;

import sun.font.TrueTypeFont;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/3/2
 */
public class Interview32_3 {
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

    /**
     * 分析打印规律，通过两个栈来实现
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }

        List<LinkedList<TreeNode>> stackArr = new ArrayList<>(2);
        stackArr.add(new LinkedList<TreeNode>());
        stackArr.add(new LinkedList<TreeNode>());

        int current = 0;
        int next = 1;
        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        stackArr.get(current).push(root);

        while (!stackArr.get(0).isEmpty() || !stackArr.get(1).isEmpty()) {
            TreeNode node = stackArr.get(current).pop();
            levelList.add(node.val);
            if (current == 0) {
                if (null != node.left) {
                    stackArr.get(next).push(node.left);
                }
                if (null != node.right) {
                    stackArr.get(next).push(node.right);
                }
            } else {
                if (null != node.right) {
                    stackArr.get(next).push(node.right);
                }
                if (null != node.left) {
                    stackArr.get(next).push(node.left);
                }
            }
            if (stackArr.get(current).isEmpty()) {
                current = 1 - current;
                next = 1 - next;
                retList.add(levelList);
                levelList = new ArrayList<>();
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
