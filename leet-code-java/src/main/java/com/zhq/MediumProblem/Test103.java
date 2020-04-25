package com.zhq.MediumProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/4/19
 */
public class Test103 {

    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        if (null == root) {
            return retList;
        }

        int rightFlag = 1;
        Stack<TreeNode> rightDirectionStack = new Stack<>();
        Stack<TreeNode> leftDirectionStack = new Stack<>();

        rightDirectionStack.push(root);
        while (!rightDirectionStack.isEmpty() || !leftDirectionStack.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            if (rightFlag == 1) {
                while (!rightDirectionStack.isEmpty()) {
                    TreeNode node = rightDirectionStack.pop();
                    tmpList.add(node.val);
                    if (null != node.left) {
                        leftDirectionStack.push(node.left);
                    }
                    if (null != node.right) {
                        leftDirectionStack.push(node.right);
                    }
                }
            } else {
                while (!leftDirectionStack.isEmpty()) {
                    TreeNode node = leftDirectionStack.pop();
                    tmpList.add(node.val);
                    if (null != node.right) {
                        rightDirectionStack.push(node.right);
                    }
                    if (null != node.left) {
                        rightDirectionStack.push(node.left);
                    }
                }
            }
            retList.add(tmpList);
            rightFlag = 1 - rightFlag;
        }

        return retList;
    }

}
