package LeetCode.Java;

import LeetCode.Java.component.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallest {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
         * <p>
         * 说明：
         * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了8.70%的用户
         */
        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            while (true) {
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }
                root = stack.removeLast();
                if (--k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }
    }
}
