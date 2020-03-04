package com.zhq;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/3/4
 */
public class Interview54 {
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

    public static int kthLargest(TreeNode root, int k) {
        if (null == root) {
            return 0;
        }

        List<Integer> orOrderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                orOrderList.add(current.val);
                current = current.right;
            }
        }

        int index = orOrderList.size() - k;
        return orOrderList.get(index);
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node1, node4);

        System.out.println(kthLargest(node3, 1));

    }


}
