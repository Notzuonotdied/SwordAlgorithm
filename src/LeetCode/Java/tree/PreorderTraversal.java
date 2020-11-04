package LeetCode.Java.tree;

import common.java.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public static void main(String[] args) {

    }

    private static class Solution1 {

        /**
         * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
         *
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：36.7 MB, 在所有 Java 提交中击败了60.29% 的用户
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            preorder(root, result);
            return result;
        }

        private void preorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }

            result.add(root.val);
            if (root.left != null) {
                preorder(root.left, result);
            }
            if (root.right != null) {
                preorder(root.right, result);
            }
        }
    }

    private static class Solution2 {

        /**
         * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
         *
         * 执行用时：1 ms, 在所有 Java 提交中击败了42.18% 的用户
         * 内存消耗：36.6 MB, 在所有 Java 提交中击败了72.43% 的用户
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            preorder(root, result);
            return result;
        }

        private void preorder(TreeNode root, List<Integer> result) {
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    result.add(root.val);
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
        }
    }
}
