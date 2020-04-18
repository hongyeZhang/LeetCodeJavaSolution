package com.zhq.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/4/18
 */
public class Test1 {

    static class TreeNode {
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



    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    @Test
    public void testNumberOf1() {
        int n = 10;
        System.out.println(NumberOf1(10));
    }


    public void reOrderArray(int [] array) {
        if (null == array || array.length < 2) {
            return;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && isOdd(array[left])) {
                left++;
            }
            while (left < right && !isOdd(array[right])) {
                right--;
            }
            swap(array, left, right);
        }
    }

    public boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void testReOrderArray() {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        reOrderArray(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }

    }

    /**
     * 以时间换空间
     * 类似于插入排序
     *
     * @param array
     */
    public void reOrderArray2(int [] array) {
        //相对位置不变，稳定性
        //插入排序的思想
        int m = array.length;
        int k = 0;
        //记录已经摆好位置的奇数的个数
        for (int i = 0; i < m; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                while (j > k) {
                    //j >= k+1
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    j--;
                }
                k++;
            }
        }
    }

    @Test
    public void testReOrderArray2() {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        reOrderArray2(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }

    }


    /**
     * 根节点为空的时候是否相等，需要参考题目给出的要求
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) {
            return true;
        } else if (null != root1 && null == root2) {
            return true;
        } else if (null == root1 && null != root2) {
            return false;
        } else {
            if (root1.val == root2.val) {
                // 这个当做条件使用，不能直接返回
                if (isSubTree(root1, root2)) {
                    return true;
                }
            }
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
    }

    public boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) {
            return true;
        } else if (null != root1 && null == root2) {
            return true;
        } else if (null == root1 && null != root2) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }


    /**
     *
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
     * 假设输入的数组的任意两个数字都互不相同。
     *
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (null == sequence || sequence.length == 0) {
            return false;
        }
        return verifySquenceOfBSTCore(sequence, 0, sequence.length - 1);
    }

    public boolean verifySquenceOfBSTCore(int[] sequence, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return true;
        }

        int rootVal = sequence[endIndex];
        int left = startIndex;
        while (left < endIndex && sequence[left] < rootVal) {
            left++;
        }

        if (left == endIndex) {
            // 只有左子树
            return verifySquenceOfBSTCore(sequence, startIndex, endIndex - 1);
        } else if (left == startIndex) {
            // 只有右子树
            while (left < endIndex) {
                if (sequence[left] < rootVal) {
                    return false;
                }
                left++;
            }
            return verifySquenceOfBSTCore(sequence, startIndex, endIndex - 1);
        }

        return verifySquenceOfBSTCore(sequence, startIndex, left - 1) && verifySquenceOfBSTCore(sequence, left, endIndex);
    }

    @Test
    public void test() {
        int[] nums = new int[] {4, 8, 6, 12, 16, 14, 10};
        System.out.println(VerifySquenceOfBST(nums));

    }


    /**
     * 和为某偶一个值的路径
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> retlist = new ArrayList<>();
        if (null == root) {
            return retlist;
        }

        Stack<TreeNode> currentPath = new Stack<>();
        findPathCore(root, 0, target, currentPath, retlist);
        return retlist;
    }


    public void findPathCore(TreeNode node, int currentSum, int target, Stack<TreeNode> currentPath,
                    ArrayList<ArrayList<Integer>> retList) {
        if (null == node) {
            return;
        }
        currentPath.push(node);
        currentSum += node.val;

        if (currentSum > target) {
            currentPath.pop();
            return;
        } else if (currentSum == target) {
            if (node.left == null && node.right == null) {
                ArrayList<TreeNode> tmpNodeList = new ArrayList<>();
                ArrayList<Integer> tmpValList = new ArrayList<>();
                for (TreeNode treeNode : tmpNodeList) {
                    tmpValList.add(treeNode.val);
                }
                retList.add(tmpValList);
                currentPath.pop();
            } else {
                currentPath.pop();
            }
        }
        findPathCore(node.left, currentSum, target, currentPath, retList);
        findPathCore(node.right, currentSum, target, currentPath, retList);
        currentPath.pop();
    }









}
