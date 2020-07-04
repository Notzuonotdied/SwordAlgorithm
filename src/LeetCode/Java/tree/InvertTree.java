package LeetCode.Java.tree;

import common.java.TreeNode;

public class InvertTree {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 翻转一棵二叉树。
         *
         * 示例：
         * 输入：
         *      4
         *    /   \
         *   2     7
         *  / \   / \
         * 1   3 6   9
         * 输出：
         *      4
         *    /   \
         *   7     2
         *  / \   / \
         * 9   6 3   1
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/invert-binary-tree
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗 :37.1 MB, 在所有 Java 提交中击败了6.00%的用户
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
            return root;
        }
    }
}
