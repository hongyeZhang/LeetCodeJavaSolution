package datastructure.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @program: data-structure-and-algorithm
 * @description: https://www.cnblogs.com/llguanli/p/7363657.html
 * @author: ZHQ
 * @create: 2019-06-23 15:46
 **/
public class BinaryTreeTraversal {
    /**
    * @Description:
     * 深度遍历 :前序、中序以及后序
     * 广度遍历
     * 四种基本的遍历思想为：
     * 前序遍历：根结点 ---> 左子树 ---> 右子树
     * 中序遍历：左子树---> 根结点 ---> 右子树
     * 后序遍历：左子树 ---> 右子树 ---> 根结点
     * 层次遍历：仅仅需按层次遍历就可以
    **/

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    /** 递归前序
     * @param root
     */
    public static void preOrderTraverseRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderTraverseRecursive(root.left);
            preOrderTraverseRecursive(root.right);
        }
    }

    /** 非递归前序1
     * @param root
     */
    public static void preOrderTraverseNonRecursive(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()) {
                TreeNode tmpNode = stack.pop();
                System.out.print(tmpNode.val + " ");
                if (tmpNode.right != null) {
                    stack.push(tmpNode.right);
                }
                if (tmpNode.left != null) {
                    stack.push(tmpNode.left);
                }
            }
        }
    }

    /** 非递归前序2
     * 依据前序遍历的顺序，优先訪问根结点。然后在訪问左子树和右子树。所以。对于随意结点node。
     * 第一部分即直接訪问之，之后在推断左子树是否为空，不为空时即反复上面的步骤，直到其为空。
     * 若为空。则须要訪问右子树。注意。在訪问过左孩子之后。须要反过来訪问其右孩子
     * @param root
     */
    public static void preOrderTraverseNonRecursive2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                System.out.print(node.val + " ");
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /** 非递归前序遍历
     * @param root
     */
    public void preOrderTraverse(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.print(pNode.val + " ");
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
    }


    /**
     * 递归中序遍历
     * @param root
     */
    public static void inOrderTraverseRecursive(TreeNode root) {
        if (root != null) {
            inOrderTraverseRecursive(root.left);
            System.out.print(root.val + " ");
            inOrderTraverseRecursive(root.right);
        }
    }



    /** 非递归的中序遍历
     * 在前序遍历的基础上，仅仅只是訪问的顺序移到出栈时
     * @param root
     */
    public static void inOrderTraverseNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    /** 递归后续遍历
     * @param root
     */
    public static void postOrderTraverseRecursive(TreeNode root) {
        if (root != null) {
            postOrderTraverseRecursive(root.left);
            postOrderTraverseRecursive(root.right);
            System.out.print(root.val + " ");
        }
    }

    /** 非递归后续遍历
     * @param root
     */
    public static void postOrderTraverseNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                map.put(node.val, 1);
                node = node.left;
            } else {
                node = stack.peek();
                if (map.get(node.val) == 2) {
                    // 第二次访问，需要弹出
                    stack.pop();
                    System.out.print(node.val + " ");
                    node = null;
                } else {
                    map.put(node.val, 2);
                    node = node.right;
                }
            }
        }
    }

    /**
    * @Description: 层序遍历
    **/
    public static void levelTraverse(TreeNode root) {
        if (root != null) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;


        System.out.println("前序 + 递归 ： ");
        preOrderTraverseRecursive(node1);
        System.out.println();

        System.out.println("前序 + 非递归（1） ： ");
        preOrderTraverseNonRecursive(node1);
        System.out.println();

        System.out.println("前序 + 非递归（2） ： ");
        preOrderTraverseNonRecursive2(node1);
        System.out.println();


        System.out.println("============================");
        System.out.println("中序 + 递归 ： ");
        inOrderTraverseRecursive(node1);
        System.out.println();

        System.out.println("中序 + 非递归 ： ");
        inOrderTraverseNonRecursive(node1);
        System.out.println();

        System.out.println("============================");
        System.out.println("后序 + 递归 ： ");
        postOrderTraverseRecursive(node1);
        System.out.println();

        System.out.println("后序 + 非递归 ： ");
        postOrderTraverseNonRecursive(node1);
        System.out.println();


        System.out.println("============================");
        System.out.println("层序（广度优先）： ");
        levelTraverse(node1);
        System.out.println();











    }





}
