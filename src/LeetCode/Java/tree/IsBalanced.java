package LeetCode.Java.tree;

import LeetCode.Java.component.TreeNode;

/**
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-balance-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsBalanced {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 使用递归的方式求解。
         *
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.96% 的用户
         * 内存消耗：39.5 MB, 在所有 Java 提交中击败了100.00% 的用户
         */
        public static boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (Math.abs(getTreeDepth(root.left) - getTreeDepth(root.right)) > 1) {
                return false;
            }

            return isBalanced(root.left) && isBalanced(root.right);
        }

        private static int getTreeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(getTreeDepth(root.left), getTreeDepth(root.right)) + 1;
        }
    }
}
