package LeetCode.Java;

import java.util.*;

public class LowestCommonAncestor1 {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
         * <p>
         * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
         * <p>
         * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * PS: 这种思路比较清晰，容易理解。
         * <p>
         * 题解：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetcod/
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            Map<TreeNode, TreeNode> parent = new HashMap<>();

            parent.put(root, null);
            stack.push(root);
            while (!parent.containsKey(p) || !parent.containsKey(q)) {
                TreeNode node = stack.pop();

                if (node.left != null) {
                    parent.put(node.left, node);
                    stack.push(node.left);
                }
                if (node.right != null) {
                    parent.put(node.right, node);
                    stack.push(node.right);
                }
            }

            Set<TreeNode> ancestors = new HashSet<>();
            while (p != null) {
                ancestors.add(p);
                p = parent.get(p);
            }
            while (!ancestors.contains(q)) {
                q = parent.get(q);
            }
            return q;
        }
    }

    private static class Solution2 {
        private TreeNode res;

        /**
         * java 打败百分之100，递归详解
         * <p>
         * 题解：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236java-da-bai-bai-fen-zhi-100di-gui-xiang-jie-by-/
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            res = null;
            contains(root, p, q);
            return res;
        }

        private boolean contains(TreeNode x, TreeNode p, TreeNode q) {
            if (x == null) {
                return false;
            }
            boolean leftCon = contains(x.left, p, q);
            boolean rightCon = contains(x.right, p, q);
            if ((x == p && rightCon) || (x == q && leftCon) || (x == p && leftCon) || (x == q && rightCon) || (leftCon && rightCon)) {
                res = x;
                return true;
            }
            return x == p || x == q || leftCon || rightCon;
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
