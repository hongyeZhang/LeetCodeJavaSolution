package com.zhq.MediumProblem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/18
 */
public class Test515 {

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
     * 广度遍历
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if (null == root) {
            return retList;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; ++i) {
                TreeNode tmpNode = deque.pollFirst();
                max = Math.max(max, tmpNode.val);
                if (null != tmpNode.left) {
                    deque.offer(tmpNode.left);
                }
                if (null != tmpNode.right) {
                    deque.offer(tmpNode.right);
                }
            }
            retList.add(max);
        }

        return retList;
    }



}
