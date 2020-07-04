package LeetCode.Java;

import common.java.TreeNode;

public class LowestCommonAncestor {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
         * <p>
         * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先
         * 且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
         * <p>
         * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 题解：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/li-yong-cheng-ji-pan-duan-die-dai-di-gui-java-by-l/
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode curr = root;
            int pv = p.val, qv = q.val;
            while ((curr.val - pv) * (curr.val - qv) > 0) {
                curr = curr.val > pv ? curr.left : curr.right;
            }
            return curr;
        }
    }
}
