package datastructure.tree;

import java.util.LinkedList;

/**
 * @program: data-structure-and-algorithm
 * @description: https://www.cnblogs.com/llguanli/p/7363657.html
 * @author: ZHQ
 * @create: 2019-06-23 15:46
 **/
public class BinaryTreeTraversal {
    /**
    * @Description:
     * 二叉树是一种非常重要的数据结构，非常多其他数据结构都是基于二叉树的基础演变而来的。
     * 对于二叉树，有深度遍历和广度遍历，深度遍历有前序、中序以及后序三种遍历方法，
     * 广度遍历即我们寻常所说的层次遍历。由于树的定义本身就是递归定义，
     * 因此採用递归的方法去实现树的三种遍历不仅easy理解并且代码非常简洁，而对于广度遍历来说，
     * 须要其他数据结构的支撑。比方堆了。所以。对于一段代码来说，可读性有时候要比代码本身的效率要重要的多。
     * 四种基本的遍历思想为：
     * 前序遍历：根结点 ---> 左子树 ---> 右子树
     * 中序遍历：左子树---> 根结点 ---> 右子树
     * 后序遍历：左子树 ---> 右子树 ---> 根结点
     * 层次遍历：仅仅需按层次遍历就可以
    **/


    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val+"  ");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }


    /**
    * @Description:  非递归的前序遍历
    * @Param:
    * @return:
    * @Author: ZHQ
    * @Date: 2019/6/25
    **/
    public void preOrderTraverse2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.print(pNode.val+"  ");
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
    }


    public void inOrderTraverse1(TreeNode root) {
        if (root != null) {
            inOrderTraverse1(root.left);
            System.out.print(root.val+"  ");
            inOrderTraverse1(root.right);
        }
    }


    /**
    * @Description:  非递归的中序遍历
    **/
    public void inOrderTraverse2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                System.out.print(node.val+"  ");
                pNode = node.right;
            }
        }
    }


    /**
    * @Description: 非递归的后序遍历待定
    **/
    public void postOrderTraverse1(TreeNode root) {
        if (root != null) {
            postOrderTraverse1(root.left);
            postOrderTraverse1(root.right);
            System.out.print(root.val+"  ");
        }
    }

    /**
    * @Description: 层序遍历
    **/
    public void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val+"  ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
    * @Description: 深度优先遍历
    **/
    public void depthOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val+"  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }


    public static void main(String[] args) {
        // TODO: 2019/6/25

    }





}
