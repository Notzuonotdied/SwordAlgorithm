package LeetCode.Java.tree;

import common.java.TreeNode;

public class MergeTrees {
    public static void main(String[] args) {

    }

    private interface ISolution {
        TreeNode mergeTrees(TreeNode root1, TreeNode root2);
    }

    private static class Solution implements ISolution {
        /**
         * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
         * <p>
         * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 可以使用递归来解决树的合并的问题。
         * <p>
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗 :39.7 MB, 在所有 Java 提交中击败了94.12%的用户
         */
        @Override
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return null;
            } else if (root1 == null) {
                return root2;
            } else if (root2 == null) {
                return root1;
            }
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }
}
