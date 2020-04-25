package com.zhq.SimpleProblem;

import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/19
 */
public class Test559 {

    static class Node {
        public int val;

        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 与二叉树思路一致
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (null == root) {
            return 0;
        }

        List<Node> childrenList = root.children;
        int maxDepth = 1;
        if (childrenList.size() > 0) {
            for (Node node : childrenList) {
                maxDepth = Math.max(maxDepth, maxDepth(node));
            }
            maxDepth = maxDepth + 1;
        }

        return maxDepth;
    }





}
