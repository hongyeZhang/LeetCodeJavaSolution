package algorithm.total;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * ref : https://juejin.im/post/5b8d64346fb9a01a1d4f99fa
 * @author : ZHQ
 * @date : 2020/3/4
 */
public class AllBinaryTreeAlgorithm {

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


    /** 求二叉树的节点个数
     * =============================================================================================
     * @param root
     * @return
     */
    public int getTreeNodeNum(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return getTreeNodeNum(root.left) + getTreeNodeNum(root.right) + 1;
    }

    @Test
    public void testGetTreeNodeNum() {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, null, node3);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, node2, node5);

        Assert.assertEquals(4, getTreeNodeNum(node4));
    }

    /** 求二叉树的最大深度（即求根节点的深度）
     * =============================================================================================
     * @param node
     * @return
     */
    public int maxDepth(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    @Test
    public void testMaxDepth() {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, null, node3);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, node2, node5);

        Assert.assertEquals(3, maxDepth(node4));
    }



    /** 二叉树的最小深度
     * =============================================================================================
     * @param node
     * @return
     */
    public int minDepth(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int left = minDepth(node.left);
        int right = minDepth(node.right);

        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    @Test
    public void testMinDepth() {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, null, node3);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, node2, node5);

        Assert.assertEquals(2, minDepth(node4));

        TreeNode node11 = new TreeNode(11, null, null);
        TreeNode node12 = new TreeNode(12, node11, null);

        Assert.assertEquals(2, minDepth(node12));

    }

    /** 二叉树的所有路径
     * =============================================================================================
     * @param root
     * @return
     */
    public List<List<Integer>> allPaths(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> allPathList = new ArrayList<>();
        List<Integer> currentPathList = new ArrayList<>();

        currentPathList.add(root.val);
        allPathCore(root, allPathList, currentPathList);

        for (List<Integer> list : allPathList) {
            for (Integer integer : list) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
        return allPathList;
    }

    public  void allPathCore(TreeNode node, List<List<Integer>> allPathList,
                    List<Integer> currentPathList) {
        if (null == node.left && null == node.right) {
            allPathList.add(currentPathList);
        }

        if (null != node.left) {
            List<Integer> tmpList = new ArrayList<>(currentPathList);
            tmpList.add(node.left.val);
            allPathCore(node.left, allPathList, tmpList);
        }

        if (null != node.right) {
            List<Integer> tmpList = new ArrayList<>(currentPathList);
            tmpList.add(node.right.val);
            allPathCore(node.right, allPathList, tmpList);
        }
    }


    /** 判断是否为AVL树， 是否平衡
     * =============================================================================================
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isBalancedCore(root);

    }

    public boolean isBalancedCore(TreeNode node) {
        if (node == null) {
            return true;
        }
        int leftDepth = getTreeDepth(node.left);
        int rightDepth = getTreeDepth(node.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalancedCore(node.left) && isBalancedCore(node.right);
    }

    public int getTreeDepth(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return Math.max(getTreeDepth(node.left), getTreeDepth(node.right)) + 1;
    }

    /**
     * 通过计算高度，更改flag
     */
    public class AVLTreeSoultion2{
        boolean flag = true;
        public boolean isBalanced(TreeNode root) {
            if(root==null){
                return true;
            }
            height(root);
            return flag;
        }

        private int height(TreeNode root){
            if(root==null){
                return 0;
            }
            int left = height(root.left);
            int right = height(root.right);
            if(Math.abs(left-right)>1){
                flag = false;
            }
            return 1+Math.max(left, right);
        }
    }

    /** 先序遍历二叉树（非递归）
     * =============================================================================================
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }

        List<Integer> retList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || null != current) {
            if (null != current) {
                System.out.print(current.val + "\t");
                retList.add(current.val);
                if (null != current.right) {
                    stack.push(current.right);
                }
                if (null != current.left) {
                    stack.push(current.left);
                }
                current = null;
            } else {
                current = stack.pop();
            }
        }
        return retList;
    }

    public List<Integer> preOrderTraversal2(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }

        List<Integer> retList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.val + "\t");
            retList.add(current.val);
            if (null != current.right) {
                stack.push(current.right);
            }
            if (null != current.left) {
                stack.push(current.left);
            }
        }
        return retList;
    }


    @Test
    public void testPreOrderTraversal() {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node11 = new TreeNode(11, null, null);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node10 = new TreeNode(10, node8, node11);
        TreeNode node7 = new TreeNode(7, node4, node10);

        preOrderTraversal(node7);
        System.out.println();
        preOrderTraversal2(node7);
    }

    /** 中序遍历
     * =============================================================================================
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if (null == root) {
            return retList;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || null != current) {
            if (null != current) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(current.val + "\t");
                retList.add(current.val);
                current = current.right;
            }
        }

        return retList;
    }

    @Test
    public void testInorderTraversal() {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node11 = new TreeNode(11, null, null);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node10 = new TreeNode(10, node8, node11);
        TreeNode node7 = new TreeNode(7, node4, node10);

        inorderTraversal(node7);

    }


    /** 后序遍历
     * =============================================================================================
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if (null == root) {
            return retList;
        }
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        while (!stack.isEmpty() || null != current) {
            if (null != current) {
                map.put(current, 1);
                stack.push(current);
                current = current.left;
            } else {
                current = stack.peek();
                if (map.get(current) == 2) {
                    System.out.print(current.val + "\t");
                    retList.add(current.val);
                    stack.pop();
                    current = null;
                } else {
                    map.put(current, 2);
                    current = current.right;
                }
            }
        }
        return retList;
    }

    /** 推荐的后续遍历方法
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> retList = new LinkedList<>();
        if (null == root) {
            return retList;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || null != current) {
            if (null != current) {
                stack.push(current);
                retList.addFirst(current.val);
                current = current.right;
            } else {
                current = stack.pop();
                current = current.left;
            }
        }
        return retList;
    }

    @Test
    public void testPostorderTraversal() {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node11 = new TreeNode(11, null, null);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node10 = new TreeNode(10, node8, node11);
        TreeNode node7 = new TreeNode(7, node4, node10);

//        postorderTraversal(node7);
        List<Integer> list = postorderTraversal2(node7);
        for (Integer integer : list) {
            System.out.print(integer + "\t");
        }
        System.out.println();
    }


    /** 层序遍历（普通遍历）
     * =============================================================================================
     * @param root
     * @return
     */
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if (null == root) {
            return retList;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode current = root;
        deque.addLast(current);
        while (!deque.isEmpty()) {
            current = deque.pollFirst();
            System.out.print(current.val + "\t");
            retList.add(current.val);
            if (null != current.left) {
                deque.addLast(current.left);
            }
            if (null != current.right) {
                deque.addLast(current.right);
            }
        }
        return retList;
    }

    /** 分层：从上到下打印
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        if (null == root) {
            return retList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        queue.add(current);
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < length; ++i) {
                current = queue.poll();
                levelList.add(current.val);
                if (null != current.left) {
                    queue.add(current.left);
                }
                if (null != current.right) {
                    queue.add(current.right);
                }
            }
            retList.add(levelList);
        }

        return retList;
    }

    /**
     * 层序遍历：从下到上打印
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result;
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            result = res;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                List<Integer> temp = new LinkedList<>();
                for (int i = 0; i < count; i++) {
                    TreeNode node = queue.poll();
                    temp.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                // 每次都添加到第一个位置
                res.add(0, temp);
            }
            result = res;
        }
        return result;
    }

    /** 之字型层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> printZShape(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        if (null == root) {
            return retList;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        int flag = 1;
        s1.push(root);
        List<Integer> tmpList = new ArrayList<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (flag == 1) {
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    tmpList.add(node.val);
                    if (null != node.left) {
                        s2.push(node.left);
                    }
                    if (null != node.right) {
                        s2.push(node.right);
                    }
                }
            } else {
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    tmpList.add(node.val);
                    if (null != node.right) {
                        s1.push(node.right);
                    }
                    if (null != node.left) {
                        s1.push(node.left);
                    }
                }
            }
            flag = 1 - flag;
            retList.add(new ArrayList<>(tmpList));
            tmpList.clear();
        }

        return retList;
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

//        levelOrder(node7);
//
//        System.out.println();
//        List<List<Integer>> lists = levelOrder2(node7);
//        for (List<Integer> list : lists) {
//            for (Integer integer : list) {
//                System.out.print(integer + "\t");
//            }
//            System.out.println();
//        }

        List<List<Integer>> lists = printZShape(node7);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }


    /**
     * 求二叉树第K层的节点个数
     * =============================================================================================
     * @param root
     * @param k
     * @return
     */
    public int getKLevelNumber(TreeNode root, int k) {
        if (null == root || k <= 0) {
            return 0;
        }
        if (null != root && k == 1) {
            return 1;
        }
        return getKLevelNumber(root.left, k - 1) + getKLevelNumber(root.right, k - 1);
    }

    /** 求二叉树第K层的叶子节点个数
     * =============================================================================================
     * @param root
     * @param k
     * @return
     */
    public int getKLevelLeafNumber(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        if (root != null && k == 1) {
            if (root.left == null && root.right == null) {
                return 1;
            } else {
                return 0;
            }
        }
        return getKLevelLeafNumber(root.left, k - 1) + getKLevelLeafNumber(root.right, k - 1);
    }

    @Test
    public void testGetKLevelNumber() {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node11 = new TreeNode(11, null, null);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node10 = new TreeNode(10, node8, node11);
        TreeNode node7 = new TreeNode(7, node4, node10);

        Assert.assertEquals(4, getKLevelNumber(node7, 3));
        Assert.assertEquals(2, getKLevelNumber(node7, 2));

        Assert.assertEquals(4, getKLevelLeafNumber(node7, 3));
        Assert.assertEquals(0, getKLevelLeafNumber(node7, 2));
    }




















}
