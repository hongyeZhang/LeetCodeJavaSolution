package datastructure.linkedlist;

/**
 * @program: data-structure-and-algorithm
 *  * 1) 单链表反转
 *  * 2) 链表中环的检测
 *  * 3) 两个有序的链表合并
 *  * 4) 删除链表倒数第n个结点
 *  * 5) 求链表的中间结点
 * @author: ZHQ
 * @create: 2019-06-20 21:19
 **/
public class LinkedListAlgorithm {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

//        testReverseList();
//        testCheckCircle();
//        testMergeSortedLists();
//        testDeleteLastKth();
        testFindMiddleNode();
    }


    public static void testReverseList() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printLinkedList(node1);
        printLinkedList(reverseList(node1));
    }

    public static void testCheckCircle() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;
//        System.out.println(checkCircle(node1));
        Node circleEntrance = getCircleEntrance(node1);
        System.out.println(circleEntrance.data);

    }

    public static void testMergeSortedLists() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;

        Node node4 = new Node(1);
        Node node5 = new Node(3);
        Node node6 = new Node(4);
        node4.next = node5;
        node5.next = node6;
        printLinkedList(mergeSortedLists(node1, node4));
    }

    public static void testDeleteLastKth() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        printLinkedList(node1);
        printLinkedList(deleteLastKth(node1,3));
    }

    public static void testFindMiddleNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printLinkedList(node1);
        Node middleNode = findMiddleNode(node1);
        System.out.println(middleNode.data);
    }

    /**
     * 单链表反转
    **/
    public static Node reverseList(Node head) {
        Node post = null;
        Node current = head;
        while (current.next != null) {
            Node nextNode = current.next;
            current.next = post;
            post = current;
            current = nextNode;
        }
        current.next = post;
        return current;
    }

    /**
     * 检测环  快慢指针方法
     **/
    public static boolean checkCircle(Node head) {
        if (null == head) {
            return false;
        }

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /** 找到环的入口
     * （1）判断是否有环
     * （2）判断环的长度
     * （3）找到环的入口
     * @param head
     * @return
     */
    public static Node getCircleEntrance(Node head) {
        if (null == head) {
            return head;
        }
        int circleLen = 1;
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // step 2
                slow = slow.next;
                while (slow != fast) {
                    slow = slow.next;
                    circleLen++;
                }
                break;
            }
        }
        System.out.println("the length of circle is : " + circleLen);
        // step 3
        slow = head;
        fast = head;
        int i = 0;
        while (fast.next != null && i < circleLen) {
            fast = fast.next;
            ++i;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 有序链表合并
     **/
    public static Node mergeSortedLists(Node la, Node lb) {
        if (la == null) {
            return lb;
        }
        if (lb == null) {
            return la;
        }

        Node current;
        Node head;
        Node aCurr = la;
        Node bCurr = lb;
        // 确立头结点
        if (aCurr.data <= bCurr.data) {
            current = aCurr;
            aCurr = aCurr.next;
        } else {
            current = bCurr;
            bCurr = bCurr.next;
        }
        head = current;

        while (aCurr != null && bCurr != null) {
            if (aCurr.data <= bCurr.data) {
                current.next = aCurr;
                current = current.next;
                aCurr = aCurr.next;
            } else {
                current.next = bCurr;
                current = current.next;
                bCurr = bCurr.next;
            }
        }
        if (aCurr != null) {
            current.next = aCurr;
        }
        if (bCurr != null) {
            current.next = bCurr;
        }

        return head;
    }

    /**
     * 删除倒数第K个结点
     **/
    public static Node deleteLastKth(Node head, int k) {
        Node fast = head;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        // 长度不足k
        if (fast == null) {
            return head;
        }

        Node slow = head;
        Node preSlow = null;
        while (fast.next != null) {
            fast = fast.next;
            preSlow = slow;
            slow = slow.next;
        }
        if (preSlow == null) {
            return head.next;
        }
        preSlow.next = preSlow.next.next;

        return head;
    }

    /**
     * 求中间结点
     **/
    public static Node findMiddleNode(Node head) {
        if (head == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 删除列表结点
     * @param head
     * @param val
     * @return
     */
    public static Node deleteNode(Node head, int val) {
        Node current = head;
        Node pre = null;

        // 头结点
        if (head.data == val) {
            return head.next;
        }

        // 非头结点
        pre = current;
        current = current.next;
        while (current != null) {
            if (current.data == val) {
                pre.next = current.next;
                break;
            }
            pre = current;
            current = current.next;
        }

        return head;
    }

    /** 输出
     * @param head
     */
    public static void printLinkedList(Node head) {
        Node current = head;
        while (current.next != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println(current.data);
    }

}
