package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/25
 */
public class Test662 {

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


    /**
     * todo 有错误
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int maxWidth = 1;
        int level = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<TreeNode> tmpList = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode tmpNode = deque.pollFirst();
                tmpList.add(tmpNode);
                if (tmpNode != null) {
                    deque.offer(tmpNode.left);
                    deque.offer(tmpNode.right);
                }
            }
            maxWidth = Math.max(maxWidth, getLevelWidth(tmpList));
        }
        return maxWidth;
    }


    public int getLevelWidth(List<TreeNode> list) {
        if (list.size() == 0) {
            return 0;
        }

        int len = list.size();
        int left = 0;
        int right = list.size() - 1;
        while (left < len && list.get(left) == null) {
            left++;
        }
        while (right >= 0 && list.get(right) == null) {
            right--;
        }
        if (left == len || right < 0) {
            return 0;
        }
        return right - left + 1;
    }


    @Test
    public void test1() {
        List<TreeNode> list = new ArrayList<>();
        list.add(null);
//        list.add(new TreeNode(1));
//        list.add(new TreeNode(3));
        list.add(null);

        System.out.println(getLevelWidth(list));

    }

}
