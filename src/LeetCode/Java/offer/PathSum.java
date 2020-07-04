package LeetCode.Java.offer;

import LeetCode.Java.component.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {
    public static void main(String[] args) {
        // 模拟树结构
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);

        root.right.right = new TreeNode(11);

        System.out.println(Solution1.pathSum(root, 8));
    }

    /**
     * 使用回溯法即可解决问题。
     *
     * @see LeetCode.Java.tree.PathSum 详见这个题目，属于变种题目。
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了100.00% 的用户
     */
    private static class Solution1 {
        public static List<List<Integer>> pathSum(TreeNode root, int sum) {
            LinkedList<List<Integer>> pathSum = new LinkedList<>();
            LinkedList<Integer> singlePathSum = new LinkedList<>();
            recursionPathSum(root, pathSum, singlePathSum, sum);
            return pathSum;
        }

        private static void recursionPathSum(TreeNode root,
                                             LinkedList<List<Integer>> pathSum,
                                             LinkedList<Integer> singlePathSum,
                                             int target) {
            if (root == null) {
                return;
            }

            target -= root.val;
            singlePathSum.add(root.val);

            if (target == 0 && root.left == null && root.right == null) {
                pathSum.add(new LinkedList<>(singlePathSum));
            }

            recursionPathSum(root.left, pathSum, singlePathSum, target);
            recursionPathSum(root.right, pathSum, singlePathSum, target);

            singlePathSum.removeLast();
        }
    }
}
