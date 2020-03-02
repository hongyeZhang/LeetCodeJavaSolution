package com.zhq;

/**
 * @author : ZHQ
 * @date : 2020/3/2
 */
public class Interview33 {

    /** 分析后续遍历的规律，直接递归即可
     * @param postorder
     * @return
     */
    public static boolean verifyPostorder(int[] postorder) {
        if (null == postorder) {
            return false;
        }
        if (postorder.length < 3) {
            return true;
        }

        return verifyPostOrderCore(postorder, 0, postorder.length - 1);
    }

    public static boolean verifyPostOrderCore(int[] postorder, int start, int end) {
        if (end - start < 2) {
            return true;
        }
        int root = postorder[end];
        int index = start;
        while (index < end && postorder[index] < root) {
            index++;
        }
        // 找到左子树子序列与右子树子序列的分界点
        int mid = index;
        while (index < end) {
            // 校验右子树子序列是否符合要求
            if (postorder[index] < root) {
                return false;
            }
            index++;
        }

        return verifyPostOrderCore(postorder, start, mid - 1) && verifyPostOrderCore(postorder, mid,
                        end - 1);
    }


    public static void main(String[] args) {
//        int[] postorder = new int[] {7, 5};
//        int[] postorder = new int[] {4, 6, 5};
//        int[] postorder = new int[] {1, 3, 2, 6, 5};
//        int[] postorder = new int[] {1, 6, 3, 2, 5};
        int[] postorder = new int[] {4, 8, 6, 12, 16, 14, 10};
        System.out.println(verifyPostorder(postorder));

    }
}
