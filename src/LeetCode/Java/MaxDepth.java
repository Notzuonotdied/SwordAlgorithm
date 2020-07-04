package LeetCode.Java;


import common.java.TreeNode;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDepth {
    public static void main(String[] args) {

    }

    private static class Solution2 {
        private static int max = 0;
        private static int count = 0;

        /**
         * 对于这个题目求解的树的深度就想到了DFS,之前做到了一个回溯法的题目感觉很巧妙，这个地方也可以使用，无需容器。
         * <p>
         * 核心的思想就是DFS
         * <p>
         * 然后利用count计数器进行计数，当递归的时候每次都加1，出来的时候则减1
         * <p>
         * 最后取递归过程中的最大值max。
         * <p>
         * 作者：nu-li-de-bao-zi
         * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/solution/qing-xi-zhi-jie-de-fang-fa-bfshui-su-fa-by-nu-li-d/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * <p>
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：39.6 MB, 在所有 Java 提交中击败了100.00% 的用户
         */
        public static int maxDepth(TreeNode root) {
            if (count > max) {
                max = count;
            }
            if (root == null) {
                return max;
            }
            count++;
            maxDepth(root.left);
            maxDepth(root.right);
            count--;
            return max;
        }
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
}
