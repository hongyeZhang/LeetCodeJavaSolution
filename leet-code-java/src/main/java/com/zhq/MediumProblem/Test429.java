package com.zhq.MediumProblem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : ZHQ
 * @date : 2020/4/19
 */
public class Test429 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 与二叉树的处理一致
     * AC
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> retList = new ArrayList<>();
        if (null == root) {
            return retList;
        }

        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                Node current = deque.pollFirst();
                tmpList.add(current.val);
                List<Node> childrenList = current.children;
                for (Node node : childrenList) {
                    deque.offer(node);
                }
            }
            retList.add(tmpList);
        }

        return retList;
    }

}
