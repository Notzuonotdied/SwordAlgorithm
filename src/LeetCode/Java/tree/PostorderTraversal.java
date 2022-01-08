package LeetCode.Java.tree;

import common.java.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：36.7 MB, 在所有 Java 提交中击败了92.39% 的用户
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            postorder(root, result);
            return result;
        }

        private void postorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }

            if (root.left != null) {
                postorder(root.left, result);
            }
            if (root.right != null) {
                postorder(root.right, result);
            }
            result.add(root.val);
        }
    }

    private static class Solution2 {
        /**
         * 执行用时：1 ms, 在所有 Java 提交中击败了50.92% 的用户
         * 内存消耗：36.6 MB, 在所有 Java 提交中击败了93.49% 的用户
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            postorder(root, result);
            return result;
        }

        private void postorder(TreeNode root, List<Integer> result) {
            Stack<TreeNode> stack = new Stack<>();

            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || prev == root.right) {
                    result.add(root.val);
                    prev = root;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
        }
    }
}
