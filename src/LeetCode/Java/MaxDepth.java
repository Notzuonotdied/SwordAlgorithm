package LeetCode.Java;

public class MaxDepth {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个二叉树，找出其最大深度。
         * <p>
         * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
         * <p>
         * 说明: 叶子节点是指没有子节点的节点。
         * <p>
         * 题目：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
         */
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int left_height = maxDepth(root.left);
                int right_height = maxDepth(root.right);
                return java.lang.Math.max(left_height, right_height) + 1;
            }
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
