package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/3/4
 */
public class Test {
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

    public List<String> data = new ArrayList<>();
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return data;
        }

        childNode(root, String.valueOf(root.val));
        return data;
    }


    public void childNode(TreeNode root, String str){
        if(root.left != null){
            String left = str + "->" + root.left.val;
            childNode(root.left, left);
        }
        if(root.right != null){
            String right = str + "->" + root.right.val;
            childNode(root.right, right);
        }
        if(root.right == null && root.left == null){
            data.add(str);
        }
    }






    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node1, node4);

        Test test = new Test();
        List<String> list = test.binaryTreePaths(node3);
        for (String s : list) {
            System.out.println(s);
        }

        allPaths(node3);





    }





}
