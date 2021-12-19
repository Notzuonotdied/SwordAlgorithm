package LeetCode.Java.tree;

import common.java.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {

    }

    private interface ISolution {
        List<List<Integer>> levelOrder(TreeNode root);
    }

    private static class Solution1 implements ISolution {
        /**
         * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
         * 示例：
         * 二叉树：[3,9,20,null,null,15,7],
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         * 返回其层序遍历结果：
         * [
         *   [3],
         *   [9,20],
         *   [15,7]
         * ]
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 更多详见：BFS 的使用场景总结：层序遍历、最短路径问题
         * <p>
         * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
         *
         * 执行用时：1 ms, 在所有 Java 提交中击败了90.02% 的用户
         * 内存消耗：38.6 MB, 在所有 Java 提交中击败了54.39% 的用户
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            TreeNode tmp;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelRes = new ArrayList<>(size);
                // 逐层遍历
                for (int i = 0; i < size; ++i) {
                    // 每次都弹出队列头
                    tmp = queue.poll();
                    if (tmp == null) {
                        continue;
                    }
                    // 逐次将树的左右节点追加进去
                    if (tmp.left != null) {
                        queue.add(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue.add(tmp.right);
                    }
                    // 保存当前层的结果
                    levelRes.add(tmp.val);
                }
                ans.add(levelRes);
            }
            return ans;
        }
    }
}
