package com.zhq;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : ZHQ
 * @date : 2020/2/29
 */
public class Interview07 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    Map<Integer, Integer> dic = new HashMap<>();
    int[] po;

    /** 参考题解
     *  https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        // 建立根节点root： 值为前序遍历中索引为pre_root的节点值。
        TreeNode root = new TreeNode(po[pre_root]);
        // 搜索根节点root在中序遍历的索引i
        int i = dic.get(po[pre_root]);

        root.left = recur(pre_root + 1, in_left, i - 1);
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
        return root;
    }

    public static void main(String[] args) {

    }





}
