package LeetCode.Java.tree;

import common.java.TreeNode;

import java.util.*;

public class InorderTraversal {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个二叉树，返回它的中序 遍历。
         *
         * 示例:
         *
         * 输入: [1,null,2,3]
         *    1
         *     \
         *      2
         *     /
         *    3
         *
         * 输出: [1,3,2]
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：36.7 MB, 在所有 Java 提交中击败了87.45% 的用户
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            inorder(root, result);
            return result;
        }

        private void inorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }

            if (root.left != null) {
                inorder(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                inorder(root.right, result);
            }
        }
    }

    private static class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            inorder(root, result);
            return result;
        }

        /**
         * 执行用时：1 ms, 在所有 Java 提交中击败了45.09% 的用户
         * 内存消耗：36.8 MB, 在所有 Java 提交中击败了84.80% 的用户
         */
        private void inorder(TreeNode root, List<Integer> result) {
            Deque<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
    }
}
