package interview.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.*;

/**
 * @author : ZHQ
 * @date : 2020/4/11
 */
public class BinaryTreePracticeAlgorithm {
    private static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 给定一个二叉树，返回二叉树每层的最左的值
     * @param root
     * @return
     */
    public List<Integer> getLeftValueListFromLevelTravel(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }

        List<Integer> retList = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        TreeNode current = root;
        queue.addLast(current);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; ++i) {
                TreeNode tmpNode = queue.pollFirst();
                if (i == 0) {
                    retList.add(tmpNode.val);
                }
                if (tmpNode.left != null) {
                    queue.addLast(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.addLast(tmpNode.right);
                }
            }
        }
        return retList;
    }

    @Test
    public void testGetLeftValueListFromLevelTravel() {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node11 = new TreeNode(11, null, null);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node10 = new TreeNode(10, node8, node11);
        TreeNode node7 = new TreeNode(7, node4, node10);

        List<Integer> retList = getLeftValueListFromLevelTravel(node7);
        for (Integer integer : retList) {
            System.out.print(integer + "\t");
        }
    }


    public TreeNode getMirrorTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        TreeNode left = root.left;
        root.left = getMirrorTree(root.right);
        root.right = getMirrorTree(left);
        return root;
    }



    public List<List<Integer>> printZShape(TreeNode head) {
        List<List<Integer>> retList = new ArrayList<>();
        if (null == head) {
            return retList;
        }

        TreeNode current = head;
        int flag = 1;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(current);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            if (flag == 1) {
                while (!s1.isEmpty()) {
                    TreeNode tmpNode = s1.pop();
                    tmpList.add(tmpNode.val);
                    if (tmpNode.left != null) {
                        s2.push(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        s2.push(tmpNode.right);
                    }
                }
            } else {
                while (!s2.isEmpty()) {
                    TreeNode tmpNode = s2.pop();
                    tmpList.add(tmpNode.val);
                    if (tmpNode.right != null) {
                        s1.push(tmpNode.right);
                    }
                    if (tmpNode.left != null) {
                        s1.push(tmpNode.left);
                    }
                }
            }
            flag = 1 - flag;
            retList.add(tmpList);
        }

        return retList;
    }

    @Test
    public void testPrintZShape() {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node11 = new TreeNode(11, null, null);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node10 = new TreeNode(10, node8, node11);
        TreeNode node7 = new TreeNode(7, node4, node10);

        List<List<Integer>> lists = printZShape(node7);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }

    }

























}
