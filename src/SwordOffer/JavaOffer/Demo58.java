package SwordOffer.JavaOffer;

import common.java.TreeNode;

public class Demo58 {
    public static void main(String[] args) {

    }

    private interface ISymmetrical {
        boolean isSymmetric(TreeNode root);
    }

    private static class Solution1 implements ISymmetrical {
        /**
         * 给定一个二叉树，检查它是否是镜像对称的。
         * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
         *     1
         *    / \
         *   2   2
         *  / \ / \
         * 3  4 4  3
         * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
         *     1
         *    / \
         *   2   2
         *    \   \
         *    3    3
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/symmetric-tree
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：36.2 MB, 在所有 Java 提交中击败了92.13% 的用户
         */
        @Override
        public boolean isSymmetric(TreeNode root) {
            return root == null || jude(root.left, root.right);
        }

        private boolean jude(TreeNode leftNode, TreeNode rightNode) {
            if (leftNode == null && rightNode == null) {
                return true;
            } else if (leftNode == null || rightNode == null) {
                return false;
            }

            if (leftNode.val != rightNode.val) {
                return false;
            } else {
                return jude(leftNode.left, rightNode.right) && jude(leftNode.right, rightNode.left);
            }
        }
    }
}
