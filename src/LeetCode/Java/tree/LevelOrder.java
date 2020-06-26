package LeetCode.Java.tree;

import LeetCode.Java.component.TreeNode;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 更多详见：BFS 的使用场景总结：层序遍历、最短路径问题
         *
         * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> stack = new ArrayDeque<>();
            stack.add(root);

            TreeNode temp;
            while (!stack.isEmpty()) {
                int n = stack.size();
                List<Integer> levelRes = new ArrayList<>();
                for (int i = 0; i < n; ++i) {
                    temp = stack.poll();
                    if (temp.left != null) {
                        stack.add(temp.left);
                    }

                    if (temp.right != null) {
                        stack.add(temp.right);
                    }

                    levelRes.add(temp.val);
                }
                res.add(levelRes);
            }

            return res;
        }
    }
}
