package algorithm.total;

import org.junit.Test;

import sun.java2d.pipe.SpanIterator;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/4/7
 */
public class BinaryTreeTravelAlgorithm {
    static class TreeNode {
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

    public void preOrderTravel(TreeNode root) {
        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        stack.push(current);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            System.out.print(tmp.val + "\t");
            if (null != tmp.right) {
                stack.push(tmp.right);
            }
            if (null != tmp.left) {
                stack.push(tmp.left);
            }
        }
        System.out.println();
        System.out.println("preorder over!");
    }

    @Test
    public void testPreOrderTravel() {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node11 = new TreeNode(11, null, null);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node10 = new TreeNode(10, node8, node11);
        TreeNode node7 = new TreeNode(7, node4, node10);

        preOrderTravel(node7);
        System.out.println("correct answer should be : 7 4 3 5 10 8 11");
    }


    public void inOrderTravel(TreeNode root) {
        if (null == root) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode tmp = stack.pop();
                System.out.print(tmp.val + "\t");
                current = tmp.right;
            }
        }
        System.out.println();
        System.out.println("inorder over!");
    }

    @Test
    public void testInOrderTravel() {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node11 = new TreeNode(11, null, null);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node10 = new TreeNode(10, node8, node11);
        TreeNode node7 = new TreeNode(7, node4, node10);

        inOrderTravel(node7);

        System.out.println("correct answer should be : 3 4 5 7 8 10 11");


    }

    public void postOrderTravel(TreeNode root) {
        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        Map<TreeNode, Integer> map = new HashMap<>();
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                map.put(current, 1);
                stack.push(current);
                current = current.left;
            } else {
                current = stack.peek();
                if (map.get(current) == 2) {
                    stack.pop();
                    System.out.print(current.val + "\t");
                    current = null;
                } else {
                    map.put(current, 2);
                    current = current.right;
                }
            }
        }
        System.out.println();
        System.out.println("postorder over");
    }

    @Test
    public void testPostOrderTravel() {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node11 = new TreeNode(11, null, null);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node10 = new TreeNode(10, node8, node11);
        TreeNode node7 = new TreeNode(7, node4, node10);

        postOrderTravel(node7);
        System.out.println("correct answer should be : 3 5 4 8 11 10 7");
    }


    public void levelOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        TreeNode current = root;
        deque.addLast(current);
        while (!deque.isEmpty()) {
            TreeNode tmp = deque.pollFirst();
            System.out.print(tmp.val + "\t");
            if (null != tmp.left) {
                deque.addLast(tmp.left);
            }
            if (null != tmp.right) {
                deque.addLast(tmp.right);
            }
        }
        System.out.println();
        System.out.println("levelorder over!");
    }

    @Test
    public void testLevelOrder() {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node11 = new TreeNode(11, null, null);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node10 = new TreeNode(10, node8, node11);
        TreeNode node7 = new TreeNode(7, node4, node10);

        levelOrder(node7);
        System.out.println("correct answer should be : 7 4 10 3 5 8 11");


    }






}
