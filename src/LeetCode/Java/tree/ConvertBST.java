package LeetCode.Java.tree;

public class ConvertBST {
    public static void main(String[] args) {

    }

    private static class Solution1 {

        static int count = 0;

        /**
         * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
         * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
         *
         * 例如：
         * 输入: 原始二叉搜索树:
         *               5
         *             /   \
         *            2     13
         * 输出: 转换为累加树:
         *              18
         *             /   \
         *           20     13
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时 :1 ms, 在所有 Java 提交中击败了99.09% 的用户
         * 内存消耗 :39.7 MB, 在所有 Java 提交中击败了80.00%的用户
         */
        public static TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }

            convertBST(root.right);
            count += root.val;
            root.val = count;
            convertBST(root.left);
            return root;
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
