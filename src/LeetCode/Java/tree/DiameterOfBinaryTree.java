package LeetCode.Java.tree;

import common.java.TreeNode;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {

    }

    private interface ISolution {
        int diameterOfBinaryTree(TreeNode root);
    }

    private static class Solution1 implements ISolution {

        /**
         * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
         * 示例 :
         * 给定二叉树
         *
         *           1
         *          / \
         *         2   3
         *        / \
         *       4   5
         *
         * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
         * 注意：两结点之间的路径长度是以它们之间边的数目表示。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：38 MB, 在所有 Java 提交中击败了93.39% 的用户
         */
        @Override
        public int diameterOfBinaryTree(TreeNode root) {
            int[] dp = new int[]{1};
            depth(root, dp);
            // 这里需要减一
            // 注意：两结点之间的路径长度是以它们之间边的数目表示。
            return dp[0] - 1;
        }

        public int depth(TreeNode node, int[] dp) {
            if (node == null) {
                return 0;
            }
            // 子树个数
            int l = depth(node.left, dp);
            int r = depth(node.right, dp);
            // 计算最大深度
            dp[0] = Math.max(dp[0], l + r + 1);
            // 当前子树最大深度
            return Math.max(l, r) + 1;
        }
    }
}
