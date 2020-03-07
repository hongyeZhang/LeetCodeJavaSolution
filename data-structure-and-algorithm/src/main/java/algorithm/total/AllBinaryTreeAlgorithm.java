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



    /** 判断两棵二叉树是否结构相同
     * =============================================================================================
     * 递归解法：
     * （1）如果两棵二叉树都为空，返回真
     * （2）如果两棵二叉树一棵为空，另一棵不为空，返回假
     * （3）如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }


    /** 判断二叉树是否平衡（AVL树）
     * @param root
     * @return
     */
    public boolean isBalancedAVL(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxHigh(root.left) - maxHigh(root.right)) <= 1 && isBalancedAVL(root.left)
                        && isBalancedAVL(root.right);
    }

    public int maxHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxHigh(root.left), maxHigh(root.right)) + 1;
    }


    /** 求二叉树的镜像
     * =============================================================================================
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode leftNode = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(leftNode);
        return root;
    }



    /** 判断二叉树是否镜像对称
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return (null == root) || isSymmetricCore(root.left, root.right);
    }

    public boolean isSymmetricCore(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricCore(left.right, right.left) && isSymmetricCore(left.left, right.right);
    }


    @Test
    public void testIsSymmetric() {
        // leetcode 测过了
    }


    /**
     * 求普通二叉树中两个节点的最低公共祖先节点
     * =============================================================================================
     * （1）如果两个节点分别在根节点的左子树和右子树，则返回根节点
     * （2）如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (null != left && null != right) {
            return root;
        }

        return null == left ? right : left;
    }

    @Test
    public void testLowestCommonAncestor() {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node0 = new TreeNode(0, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node5 = new TreeNode(5, node6, node2);
        TreeNode node1 = new TreeNode(1, node0, node8);
        TreeNode node3 = new TreeNode(3, node5, node1);

//        TreeNode node = lowestCommonAncestor(node3, node5, node1);
        TreeNode node = lowestCommonAncestor(node3, node2, node8);
    }


    /** 求二叉搜索树的最低公共祖先：（性质：左子树 < 根节点 < 右子树）
     * =============================================================================================
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode binarySearchTreeLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return binarySearchTreeLowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return binarySearchTreeLowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    @Test
    public void testBinarySearchTreeLowestCommonAncestor() {
        // leetcode 235
    }

    /**
     * 求二叉树的直径
     * =============================================================================================
     * @param root
     * @return
     */
    private int path = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diamHelper(root);
        return path;
    }

    private int diamHelper(TreeNode root){
        if (null == root) {
            return 0;
        }
        int left = diamHelper(root.left);
        int right = diamHelper(root.right);
        path = Math.max(path, left + right);
        return Math.max(left, right) + 1;
    }


    /** 由前序遍历序列和中序遍历序列重建二叉树
     * =============================================================================================
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildHelper(int[] preorder, int preStartIndex, int preEndIndex, int[] inorder,
                    int inStartIndex, int inEndIndex) {
        if (preStartIndex > preEndIndex || inStartIndex > inEndIndex) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStartIndex]);
        for (int i = inStartIndex; i <= inEndIndex; ++i) {
            if (inorder[i] == preorder[preStartIndex]) {
                //在中序遍历中找到根节点
                root.left = buildHelper(preorder, preStartIndex + 1,
                                preStartIndex + i - inStartIndex, inorder, inStartIndex, i - 1);
                root.right = buildHelper(preorder, preStartIndex + i - inStartIndex + 1,
                                preEndIndex, inorder, i + 1, inEndIndex);
            }
        }
        return root;
    }

    @Test
    public void testBuildTree() {
        // leetcode 105
    }

    /** 从中序和后序遍历中重建二叉树，与上一个方法套路一样，此处直接复制
     * =============================================================================================
     * 提示：根据前序和后序遍历无法构造出唯一的二叉树
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildTreeHelper2(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTreeHelper2(int[] inorder, int in_start, int in_end, int[] postorder,
                    int post_start, int post_end) {
        if (in_start > in_end || post_start > post_end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[post_end]);
        for (int i = in_start; i <= in_end; i++) {
            if (inorder[i] == postorder[post_end]) {
                root.left = buildTreeHelper2(inorder, in_start, i - 1, postorder, post_start,
                                post_start + i - in_start - 1);
                root.right = buildTreeHelper2(inorder, i + 1, in_end, postorder,
                                post_start + i - in_start, post_end - 1);
            }
        }
        return root;
    }

    /** 判断二叉树是不是完全二叉树
     * =============================================================================================
     * 完全二叉树是指最后一层左边是满的，右边可能慢也不能不满，然后其余层都是满的，根据这个特性，利用层遍历。
     * 如果我们当前遍历到了NULL结点，如果后续还有非NULL结点，说明是非完全二叉树。
     * @param root
     * @return
     */
    public boolean checkCompleteTree(TreeNode root) {
        if (null == root) {
            return true;
        }
        // 此处如果用 ArrayQueue 则不允许入队null 节点
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (null != node) {
                if (flag == true) {
                    return false;
                }
                queue.add(node.left);
                queue.add(node.right);
            } else {
                flag = true;
            }
        }
        return true;
    }

    @Test
    public void testCheckCompleteTree() {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node4 = new TreeNode(4, node7, node8);
        TreeNode node5 = new TreeNode(5, null, node9);
        TreeNode node1 = new TreeNode(1, node4, node5);

        Assert.assertEquals(false, checkCompleteTree(node1));
    }


    /** 树的子结构 B是否是A的子树
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        return searchRoot(A, B);
    }

    // 首先找到尽所有可能开始的根节点,然后从该根节点开始找是不是子树，如果是直接结束，不是就看A的子数其他的节点
    public static boolean searchRoot(TreeNode a, TreeNode b){
        if (a != null && b == null) {
            return true;
        } else if (a == null && b == null) {
            return true;
        } else if (a == null && b != null) {
            return false;
        } else {
            if (b.val == a.val) {
                if (isSub(a, b)) {
                    return true;
                }
            }
            return searchRoot(a.left, b) || searchRoot(a.right, b);
        }
    }

    // 判断当前根节点开始，左右子树是否相等
    public static boolean isSub(TreeNode a, TreeNode b){
        if (a == null && b == null) {
            return true;
        } else if (a != null && b == null) {
            return true;
        } else if (a == null && b != null) {
            return false;
        } else {
            return a.val == b.val && (isSub(a.left, b.left) && isSub(a.right, b.right));
        }
    }

    @Test
    public void testIsSubStructure() {
        // 剑指offer  面试题26
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (null == root) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> retList = new ArrayList<>();
        Stack<Integer> path = new Stack<>();

        findPath(root, sum, 0, retList, path);
        return retList;

    }

    /**二叉树中和为某一值的路径
     * =============================================================================================
     * 通过一个栈来维护路径上经过的节点，回到上一层时，需要将本层的节点弹出
     * @param node
     * @param expectedSum
     * @param currentSum
     * @param retList
     * @param path
     */
    public static void findPath(TreeNode node, int expectedSum, int currentSum,
                    List<List<Integer>> retList, Stack<Integer> path) {
        if (null == node) {
            return;
        }

        currentSum += node.val;
        path.push(node.val);

        if (currentSum == expectedSum && isLeafNode(node)) {
            retList.add(new ArrayList<>(path));
            path.pop();
            return;
        } else if (isLeafNode(node)) {
            path.pop();
            return;
        }

        findPath(node.left, expectedSum, currentSum, retList, path);
        findPath(node.right, expectedSum, currentSum, retList, path);
        path.pop();
    }

    public static boolean isLeafNode(TreeNode node) {
        return (null == node.left) && (null == node.right);
    }

    /**
     * 二叉树的序列化与反序列化
     */
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "#,";
            }
            StringBuffer res = new StringBuffer(root.val + ",");
            res.append(serialize(root.left));
            res.append(serialize(root.right));
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] d = data.split(",");
            Queue<String> queue = new LinkedList<>();
            for (int i = 0; i < d.length; i++) {
                queue.offer(d[i]);
            }
            return pre(queue);
        }

        public TreeNode pre(Queue<String> queue) {
            String val = queue.poll();
            if (val.equals("#")) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = pre(queue);
            node.right = pre(queue);
            return node;
        }
    }

    /** 二叉搜索树的第k个结点
     * =============================================================================================
     * 二叉搜索树按照中序遍历的顺序打印出来就是排好序的，按照中序遍历找到第 k 个结点就是所求的节点
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (null == root) {
            return Integer.MIN_VALUE;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;
        while (!stack.isEmpty() || null != current) {
            if (null != current) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode node = stack.pop();
                count++;
                if (count == k) {
                    return node.val;
                }
                node = node.right;
            }
        }
        return Integer.MIN_VALUE;
    }

    @Test
    public void testKthSmallest() {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node2, node4);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node3, node6);

        Assert.assertEquals(3, kthSmallest(node5, 3));


    }

}
