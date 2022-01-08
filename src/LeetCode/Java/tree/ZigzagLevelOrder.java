package LeetCode.Java.tree;

import common.java.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {

    public static void main(String[] args) {

    }

    private interface ISolution {
        List<List<Integer>> zigzagLevelOrder(TreeNode root);
    }

    private static class Solution1 implements ISolution {

        /**
         * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
         * 例如：
         * 给定二叉树 [3,9,20,null,null,15,7],
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         * 返回锯齿形层序遍历如下：
         * [
         *   [3],
         *   [20,9],
         *   [15,7]
         * ]
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：1 ms, 在所有 Java 提交中击败了92.95% 的用户
         * 内存消耗：38.4 MB, 在所有 Java 提交中击败了73.07% 的用户
         */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.offer(root);
            boolean isOrderLeft = true;
            while (!nodeQueue.isEmpty()) {
                LinkedList<Integer> levelList = new LinkedList<>();
                int size = nodeQueue.size();
                for (int i = 0; i < size; ++i) {
                    TreeNode curNode = nodeQueue.poll();
                    if (curNode == null) {
                        continue;
                    }
                    // 锯齿形输出数据
                    if (isOrderLeft) {
                        levelList.offerLast(curNode.val);
                    } else {
                        levelList.offerFirst(curNode.val);
                    }
                    if (curNode.left != null) {
                        nodeQueue.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        nodeQueue.offer(curNode.right);
                    }
                }
                isOrderLeft = !isOrderLeft;
                ans.add(levelList);
            }
            return ans;
        }
    }
}
