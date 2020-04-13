package algorithm.total;

import org.junit.Test;

/**
 * @author : ZHQ
 * @date : 2020/3/7
 */
public class AllListAlgorithm {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**打印链表
     * @param head
     */
    public void printList(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println(current.val);
    }

    public int calculateListLength(ListNode head) {
        if (null == head) {
            return 0;
        }
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    @Test
    public void test() {
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(calculateListLength(node1));
    }





    /** 1 在O(1)的时间范围内删除链表节点
     * =============================================================================================
     *
     * 题目描述：给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
     * 解题思路：常规的做法是从链表的头结点开始遍历，找到需要删除的节点的前驱节点，把它的 next 指向要删除节点的下一个节点，
     * 平均时间复杂度为O(n)，不满足题目要求。
     * 那是不是一定要得到被删除的节点的前一个节点呢？其实不用的。我们可以很方面地得到要删除节点的下一个节点，
     * 如果我们把下一个节点的内容复制到要删除的节点上覆盖原有的内容，再把下一个节点删除，那就相当于把当前要删除的节点删除了。
     * 举个栗子，我们要删除的节点i，先把i的下一个节点j的内容复制到i，然后把i的指针指向节点j的下一个节点。此时再删除节点j，
     * 其效果刚好是把节点i给删除了。
     * 要注意两种情况：
     * 如果链表中只有一个节点，即头节点等于要删除的节点，此时我们在删除节点之后，还需要把链表的头节点设置为NULL。
     * 如果要删除的节点位于链表的尾部，那么它就没有下一个节点，这时我们就要从链表的头节点开始，顺序遍历得到该节点的前序节点，
     * 并完成删除操作。
     *
     */
    public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        // 如果输入参数有空值就返回表头结点
        if (head == null || toBeDeleted == null) {
            return head;
        }
        // 如果删除的是头结点，直接返回头结点的下一个结点
        if (head == toBeDeleted) {
            return head.next;
        }
        // 下面的情况链表至少有两个结点
        // 在多个节点的情况下，如果删除的是最后一个元素
        if (toBeDeleted.next == null) {
            // 找待删除元素的前驱
            ListNode tmp = head;
            while (tmp.next != toBeDeleted) {
                tmp = tmp.next;
            }
            // 删除待结点
            tmp.next = null;
        }
        // 在多个节点的情况下，如果删除的是某个中间结点
        else {
            // 将下一个结点的值输入当前待删除的结点
            toBeDeleted.val = toBeDeleted.next.val;
            // 待删除的结点的下一个指向原先待删除引号的下下个结点，即将待删除的下一个结点删除
            toBeDeleted.next = toBeDeleted.next.next;
        }
        // 返回删除节点后的链表头结点
        return head;
    }

    @Test
    public void testDeleteNode() {
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        printList(node1);
        printList(deleteNode(node1, node2));
    }


    /** 2 单链表反转
     * =============================================================================================
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        // 链表个数大于1
        ListNode current = head;
        ListNode pre = null;
        while (null != current.next) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        current.next = pre;
        return current;
    }

    @Test
    public void testReverseList() {
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        printList(node1);
        printList(reverseList(node1));

    }

    /** 3 反转从m到n的部分链表
     * =============================================================================================
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        int i = 1;
        // 反转部分链表反转后的头结点
        ListNode reversedNewHead = null;
        // 反转部分链表反转后的尾结点
        ListNode reversedTail = null;
        // 原链表的头结点
        ListNode oldHead = head;
        // 反转部分链表反转前其头结点的前一个结点
        ListNode reversePreNode = null;
        ListNode reverseNextNode = null;
        while (head != null) {
            if (i > n) {
                break;
            }
            if (i == m - 1) {
                reversePreNode = head;
            }
            if (i >= m && i <= n) {
                if (i == m) {
                    reversedTail = head;
                }
                reverseNextNode = head.next;
                head.next = reversedNewHead;
                reversedNewHead = head;
                head = reverseNextNode;
            } else {
                head = head.next;
            }
            i++;
        }

        reversedTail.next = reverseNextNode;
        if (reversePreNode != null) {
            reversePreNode.next = reversedNewHead;
            return oldHead;
        } else {
            return reversedNewHead;
        }
    }

    @Test
    public void testReverseListBetween() {
        ListNode node7 = new ListNode(7, null);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        printList(node1);
        printList(reverseBetween(node1, 2, 4));
    }


    /** 4 链表向右旋转 k 个位置
     * =============================================================================================
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || k <= 0 || null == head.next) {
            return head;
        }
        // 待补充：求链表的长度，当 k = k%length
        ListNode first = head;
        ListNode second = head;
        ListNode oldHead = head;
        ListNode secondPre = null;
        int count = 1;
        while (count < k && null != first) {
            first = first.next;
            count++;
        }
        if (count < k) {
            // 说明链表长度不到k
            return head;
        }
        while (null != first.next) {
            first = first.next;
            secondPre = second;
            second = second.next;
        }

        // 移动
        first.next = oldHead;
        secondPre.next = null;
        return second;
    }

    @Test
    public void testRotateRight() {
        ListNode node6 = new ListNode(6, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        printList(node1);
        printList(rotateRight(node1, 3));
//        printList(rotateRight(node4, 6));
    }

    /**
     * 5 删除倒数第K个结点
     * =============================================================================================
     **/
    public static ListNode deleteLastKth(ListNode head, int k) {
        ListNode fast = head;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        // 长度不足k
        if (fast == null) {
            return head;
        }

        ListNode slow = head;
        ListNode preSlow = null;
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
     * 6 求中间结点
     * =============================================================================================
     **/
    public static ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /** 7. 链表划分
     * =============================================================================================
     * 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (null == head) {
            return head;
        }
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode right = rightDummy;

        ListNode current = head;
        while (null != current) {
            if (current.val < x) {
                left.next = current;
                left = left.next;
            } else {
                right.next = current;
                right = right.next;
            }
            current = current.next;
        }
        left.next = rightDummy.next;
        return leftDummy.next;
    }

    @Test
    public void testPartition() {
        ListNode node7 = new ListNode(7, null);
        ListNode node5 = new ListNode(5, node7);
        ListNode node4 = new ListNode(4, node5);
        ListNode node9 = new ListNode(9, node4);
        ListNode node1 = new ListNode(1, node9);
        printList(node1);
        printList(partition(node1, 6));
    }



    /** 8 链表求和
     * =============================================================================================
     * 题目描述：你有两个用链表代表的整数，其中每个节点包含一个数字。数字存储按照在原来整数中相反的顺序，
     * 使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        } else if (null != l1 && null == l2) {
            return l1;
        } else if (null == l1 && null != l2) {
            return l2;
        }

        // create sentinel
        ListNode sentinelNode = new ListNode(0);
        ListNode newHead = sentinelNode;
        int carry = 0;
        while (null != l1 || null != l2) {
            int num1 = null == l1 ? 0 : l1.val;
            int num2 = null == l2 ? 0 : l2.val;
            int numSum = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;
            newHead.next = new ListNode(numSum);
            newHead = newHead.next;
            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }

        // 最后一位的进位处理
        if (carry > 0) {
            newHead.next = new ListNode(1);
        }

        return sentinelNode.next;
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode l1 = new ListNode(1, null);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);

        ListNode m1 = new ListNode(4, null);
        ListNode m2 = new ListNode(5, m1);
        ListNode m3 = new ListNode(6, m2);

        printList(l3);
        printList(m3);
        printList(addTwoNumbers(l3, m3));
    }


    /** 9 单链表排序
     * =============================================================================================
     * 题目描述：在O(nlogn)时间内对链表进行排序。 快速排序：
     * @param head
     * @return
     */
    public ListNode sortListQuickSort(ListNode head) {
        //采用快速排序
        quickSort(head, null);
        return head;
    }
    public static void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode mid = partion(head, end);
            quickSort(head, mid);
            quickSort(mid.next, end);
        }
    }

    public static ListNode partion(ListNode head, ListNode end) {
        ListNode p1 = head, p2 = head.next;

        //走到末尾才停
        while (p2 != end) {
            //大于key值时，p1向前走一步，交换p1与p2的值
            if (p2.val < head.val) {
                p1 = p1.next;

                int temp = p1.val;
                p1.val = p2.val;
                p2.val = temp;
            }
            p2 = p2.next;
        }

        //当有序时，不交换p1和key值
        if (p1 != head) {
            int temp = p1.val;
            p1.val = head.val;
            head.val = temp;
        }
        return p1;
    }

    @Test
    public void testSortList() {
        ListNode node3 = new ListNode(3, null);
        ListNode node7 = new ListNode(7, node3);
        ListNode node9 = new ListNode(9, node7);
        ListNode node5 = new ListNode(5, node9);
        ListNode node1 = new ListNode(1, node5);
        printList(node1);
        printList(sortListQuickSort(node1));
//        printList(sortListMergeSort(node1));
    }

    /** 9 单链表归并排序
     * =============================================================================================
     * @param head
     * @return
     */
    public ListNode sortListMergeSort(ListNode head) {
        //采用归并排序
        if (head == null || head.next == null) {
            return head;
        }
        //获取中间结点
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        //合并
        return mergeSort(sortListMergeSort(head), sortListMergeSort(right));
    }

    /**
     * 获取链表的中间结点,偶数时取中间第一个
     * =============================================================================================
     * @param head
     * @return
     */
    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        ListNode slow = head, quick = head;
        //快2步，慢一步
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    /**
     * 10 归并两个有序的链表
     * =============================================================================================
     * @param head1
     * @param head2
     * @return
     */
    private ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2, head;
        // 得到头节点的指向
        if (head1.val < head2.val) {
            head = head1;
            p1 = p1.next;
        } else {
            head = head2;
            p2 = p2.next;
        }

        ListNode p = head;
        // 比较链表中的值
        while (p1 != null && p2 != null) {

            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        // 第二条链表空了
        if (p1 != null) {
            p.next = p1;
        }
        // 第一条链表空了
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }

    /**
     * 11 检测环  快慢指针方法
     * =============================================================================================
     **/
    public static boolean checkCircle(ListNode head) {
        if (null == head) {
            return false;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /** 12 找到环的入口
     * =============================================================================================
     * （1）判断是否有环
     * （2）判断环的长度
     * （3）找到环的入口
     * @param head
     * @return
     */
    public static ListNode getCircleEntrance(ListNode head) {
        if (null == head) {
            return head;
        }
        int circleLen = 1;
        ListNode fast = head, slow = head;
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

    /** 13 判断两个链表是否相交
     * =============================================================================================
     * 题目描述：给出两个无环单链表
     * 解题思路：
     *
     * 方法一 最直接的方法是判断 A 链表的每个节点是否在 B 链表中，但是这种方法的时间复杂度为 O(Length(A) * Length(B))。
     *
     * 方法二 转化为环的问题。把 B 链表接在 A 链表后面，如果得到的链表有环，则说明两个链表相交。可以之前讨论过
     * 的快慢指针来判断是否有环，但是这里还有更简单的方法。如果 B 链表和 A 链表相交，把 B 链表接在 A 链表后面时，
     * B 链表的所有节点都在环内，所以此时只需要遍历 B 链表，看是否会回到起点就可以判断是否相交。这个方法需要先遍历一次 A 链表，
     * 找到尾节点，然后还要遍历一次 B 链表，判断是否形成环，时间复杂度为 O(Length(A) + Length(B))。
     *
     * 方法三 除了转化为环的问题，还可以利用“如果两个链表相交于某一节点，那么之后的节点都是共有的”这个特点，如果两个链表相交，
     * 那么最后一个节点一定是共有的。所以可以得出另外一种解法，先遍历 A 链表，记住尾节点，然后遍历 B 链表，比较两个链表的尾节点，
     * 如果相同则相交，不同则不相交。时间复杂度为 O(Length(A) + Length(B))，空间复杂度为 O(1)，思路比解法 2 更简单。
     *
     * @param headA
     * @param headB
     * @return
     */
    public boolean isIntersect(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return false;
        }
        if (headA == headB) {
            return true;
        }
        while (null != headA.next) {
            headA = headA.next;
        }
        while (null != headB.next) {
            headB = headB.next;
        }
        return headA == headB;
    }


    /**
     * 14 两个链表相交扩展：求两个无环单链表的第一个相交点
     * 方法一 如果两个链表存在公共结点，那么它们从公共结点开始一直到链表的结尾都是一样的，因此我们只需要从链表的结尾开始，
     * 往前搜索，找到最后一个相同的结点即可。但是题目给出的单向链表，我们只能从前向后搜索，这时，我们就可以借助栈来完成。
     * 先把两个链表依次装到两个栈中，然后比较两个栈的栈顶结点是否相同，如果相同则出栈，如果不同，那最后相同的结点就是我们要的返回值。
     *
     * 方法二 先找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走，直到找到第一个公共结点。
     *
     * 方法三 由于2个链表都没有环，我们可以把第二个链表接在第一个链表后面，这样就把问题转化为求环的入口节点问题。
     *
     * 方法四 两个指针p1和p2分别指向链表A和链表B，它们同时向前走，当走到尾节点时，转向另一个链表，比如p1走到链表 A 的尾节点时，
     * 下一步就走到链表B，p2走到链表 B 的尾节点时，下一步就走到链表 A，当p1==p2 时，就是链表的相交点
     *
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            // 遍历完所在链表后从另外一个链表再开始
            // 当 p1 和 p2 都换到另一个链表时，它们对齐了：
            // （1）如果链表相交，p1 == p2 时为第一个相交点
            // （2）如果链表不相交，p1 和 p2 同时移动到末尾，p1 = p2 = null，然后退出循环
            p1 = (null == p1) ? headB : p1.next;
            p2 = (null == p2) ? headA : p2.next;
        }
        return p1;
    }

    /**
     *     17. 两个链表相交扩展：判断两个有环单链表是否相交
     *     题目描述：上面的问题是针对无环链表的，如果是链表有环呢？
     *     解题思路：如果两个有环单链表相交，那么它们一定共有一个环，即环上的任意一个节点都存在于两个链表上。
     *     因此可以先用之前快慢指针的方式找到两个链表中位于环内的两个节点，如果相交的话，两个节点在一个环内，
     *     那么移动其中一个节点，在一次循环内肯定可以与另外一个节点相遇。
     */






















}
