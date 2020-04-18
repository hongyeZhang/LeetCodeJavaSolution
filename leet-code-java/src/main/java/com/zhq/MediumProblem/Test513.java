package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/19
 */
public class Test513 {

    static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     *  层序遍历
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if (null == root) {
            return -1;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmpNode = deque.pollFirst();
                if (i == 0) {
                    retList.add(tmpNode.val);
                }
                if (null != tmpNode.left) {
                    deque.offer(tmpNode.left);
                }
                if (null != tmpNode.right) {
                    deque.offer(tmpNode.right);
                }
            }
        }

        return retList.get(retList.size() - 1);
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node1, node3);

        System.out.println(findBottomLeftValue(node2));

    }

}
