package datastructure.tree;

/**
 * @program: data-structure-and-algorithm
 * @description: 参考网上资料
 * @author: ZHQ
 * @create: 2019-06-23 09:29
 **/
public class BinaryTree {

    /**
     * 根节点
     */
    private Node root;

    /**
     * 查找一个节点
     */
    public Node find(int key) {
        Node current = root;
        while(current.getId() != key) {
            //如果key小于当前节点，就去找左边比当前小的节点
            if (current.getId() > key) {
                current = current.getLeftChild();
                //如果key大于当前节点，就去找右边比当前大的节点
            }else if (current.getId() < key) {
                current = current.getRightChild();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /**
     * 插入节点
     */
    public void insert(int id,int data) {
        Node newNode = new Node(id, data);
        if (root == null) {
            root = newNode;
        }else {
            Node current = root;
            Node parent = null;
            while (true) {
                parent = current;
                //如果新节点小于当前节点，我们就去左子节点找
                if (id < current.getId()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                }else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }

        }

    }
    /**
     * 前序---获取节点数据
     */
    public void preOrder(Node node) {
        if (node !=null) {
            System.out.println(node.getId()+" - ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }
    /**
     * 中序--获取节点数据
     */
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeftChild());
            System.out.println(node.getId()+" - ");
            inOrder(node.getRightChild());
        }
    }
    /**
     * 后序--获取节点数据
     */
    public void aftOrder(Node node) {
        if (node != null) {
            aftOrder(node.getLeftChild());
            aftOrder(node.getRightChild());
            System.out.println(node.getId()+" - ");
        }
    }
    /**
     * 获取最小节点
     */
    public Node getMinNode() {
        Node current = root;
        Node minNode = null;
        while (current != null) {
            minNode = current;
            current = current.getLeftChild();
        }
        return minNode;
    }
    /**
     * 获取最大节点
     */
    public Node getMaxNode() {
        Node current = root;
        Node maxNode = null;
        while (current != null) {
            maxNode = current;
            current = current.getRightChild();
        }
        return maxNode;
    }
    /**
     * 删除一个节点（删除节点有两个子节点的时候，要用它的中序后继来代替该节点）
     * 算法是：找到被删除节点的右子节点，然后查找这个右子节点下的最后一个左子节点，
     * 也就是这颗子树的最小值节点，这就是被删除节点的中序后继节点。
     * 三种情况：
     *   1.没有子节点
     *   2.只有一个子节点
     *   3.有两个子节点
     */
    public boolean delete(int key) {
        //先找到需要删除的节点
        Node current = root;
        Node parent = root;
        boolean isLeftNode = true;
        while (current.getId() != key) {
            parent = current;
            if (current.getId() > key) {
                isLeftNode = true;
                current = current.getLeftChild();
            }else if (current.getId() < key) {
                isLeftNode = false;
                current = current.getRightChild();
            }
            if (current == null) {
                return false;
            }
        }

        //1.没有子节点
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            this.noChild(parent, current, isLeftNode);
        }
        //2.只有一个节点
        else if (current.getRightChild() == null) {
            this.oneLeftNode(parent, current, isLeftNode);
        }
        else if (current.getLeftChild() == null) {
            this.oneRightNode(parent, current, isLeftNode);
        }
        //3.有两个子节点
        else {
            //找到中序后继节点
            Node successor = this.getSuccessor(current);
            if (current == root) {
                root = successor;
            }else {
                if (isLeftNode) {
                    parent.setLeftChild(successor);
                }else {
                    parent.setRightChild(successor);
                }
            }
            //设置后继节点的左节点
            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }
    /**
     * 找到要删除节点的中序后继节点
     * 算法是：找到被删除节点的右子节点，然后查找这个右子节点下的最后一个左子节点，
     *    也就是这颗子树的最小值节点，这就是被删除节点的中序后继节点。
     */
    private Node getSuccessor(Node delNode) {
        Node successor = delNode;
        Node successorParent = delNode;
        Node current = delNode.getRightChild();
        //查找最后一个左子节点
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != delNode.getLeftChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }
        return successor;
    }
    private void oneRightNode(Node parent,Node current,boolean isLeftNode) {
        if (current == root) {
            root = current.getRightChild();
        }else {
            if (isLeftNode) {
                parent.setLeftChild(current.getRightChild());
            }else {
                parent.setRightChild(current.getRightChild());
            }
        }
    }
    private void oneLeftNode(Node parent,Node current,boolean isLeftNode) {
        if (current == root) {
            root = current.getLeftChild();
        }else {
            if (isLeftNode) {
                parent.setLeftChild(current.getLeftChild());
            }else {
                parent.setRightChild(current.getLeftChild());
            }
        }
    }
    /**
     * 没有子节点
     */
    private void noChild(Node parent,Node current,boolean isLeftNode) {
        //如果是根节点
        if (current == root) {
            root = null;
        }else {
            if (isLeftNode) {
                parent.setLeftChild(null);
            }else {
                parent.setRightChild(null);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(6, 212);
        tree.insert(5, 211);
        tree.insert(8, 221);
        tree.insert(3, 321);
        tree.insert(7, 421);
        tree.insert(9, 521);

        System.out.println(tree.root.toString());
        tree.inOrder(tree.find(6));
        System.out.println(tree.getMinNode());
        System.out.println(tree.getMaxNode());
        tree.delete(5);
        System.out.println(tree.root.toString());
    }






    /**
     * 二叉树的节点
     */
    public static class Node {

        /**
         * 关键字/索引（识别数据用）
         */
        private int id;
        /**
         * 数据项（可以是任意对象T，也可以表示多个数据项）
         */
        private int data;

        private Node leftChild;
        private Node rightChild;

        Node(int id, int data) {
            super();
            this.id = id;
            this.data = data;
        }
        int getId() {
            return id;
        }
        void setId(int id) {
            this.id = id;
        }
        int getData() {
            return data;
        }
        void setData(int data) {
            this.data = data;
        }
        Node getLeftChild() {
            return leftChild;
        }
        void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }
        Node getRightChild() {
            return rightChild;
        }
        void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Node [id=" + id + ", data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
        }
    }

}
