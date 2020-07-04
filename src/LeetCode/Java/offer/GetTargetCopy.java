package LeetCode.Java.offer;

import common.java.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。
 *
 * 其中，克隆树 cloned 是原始树 original 的一个 副本 。
 *
 * 请找出在树 cloned 中，与 target 相同 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
 *
 * 注意：
 *
 *     你 不能 对两棵二叉树，以及 target 节点进行更改。
 *     只能 返回对克隆树 cloned 中已有的节点的引用。
 */
public class GetTargetCopy {
    public static void main(String[] args) {

    }

    private static class Solution2 {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            Deque<TreeNode> stack = new LinkedList<>();
            Deque<TreeNode> clonedStack = new LinkedList<>();
            TreeNode node = original;
            TreeNode cloneNode = cloned;
            while (node != null || !stack.isEmpty()) {
                if (node != null) {
                    if (node == target) {
                        return cloneNode;// 找到目标，返回
                    }
                    // 节点不空，走左子树
                    stack.push(node);
                    node = node.left;
                    clonedStack.push(cloneNode);
                    cloneNode = cloneNode.left;
                } else {
                    // 节点空了，进入右子树
                    node = stack.pop();
                    node = node.right;
                    cloneNode = clonedStack.pop();
                    cloneNode = cloneNode.right;
                }
            }
            return null;
        }
    }

    private static class Solution1 {
        /**
         * 因为只要original和target相同，则表示对应的cloned就是我们想要的节点。这个遍历过程，和左右子树并没有关系。所以我们选择前序遍历。
         * <p>
         * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：47.6 MB, 在所有 Java 提交中击败了100.00% 的用户
         */
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if (original == null) {
                return null;
            }
            if (original == target) {
                return cloned;
            }
            // 递归左子树
            TreeNode res = getTargetCopy(original.left, cloned.left, target);
            if (res == null) {
                // 递归右子树
                res = getTargetCopy(original.right, cloned.right, target);
            }
            // 返回结果
            return res;
        }
    }
}
