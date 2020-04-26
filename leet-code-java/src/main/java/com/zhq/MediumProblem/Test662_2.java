package com.zhq.MediumProblem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : ZHQ
 * @date : 2020/4/25
 */
public class Test662_2 {

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

    static class AnnotatedTreeNode {
        TreeNode node;

        int depth;

        int position;

        public AnnotatedTreeNode(TreeNode node, int depth, int position) {
            this.node = node;
            this.depth = depth;
            this.position = position;
        }
    }

    /**
     *
     * 记录每个节点的位置和深度即可
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Deque<AnnotatedTreeNode> deque = new LinkedList<>();
        deque.offer(new AnnotatedTreeNode(root, 0, 0));
        int left = 0, maxWidth = 0, currentDepth = 0;
        while (!deque.isEmpty()) {
            AnnotatedTreeNode tmpNode = deque.pollFirst();
            if (tmpNode.node != null) {
                deque.offer(new AnnotatedTreeNode(tmpNode.node.left, tmpNode.depth + 1, tmpNode.position * 2));
                deque.offer(new AnnotatedTreeNode(tmpNode.node.right, tmpNode.depth + 1, tmpNode.position * 2 + 1));
                if (tmpNode.depth != currentDepth) {
                    currentDepth = tmpNode.depth;
                    left = tmpNode.position;
                }
                maxWidth = Math.max(maxWidth, tmpNode.position - left + 1);
            }
        }

        return maxWidth;
    }







}
