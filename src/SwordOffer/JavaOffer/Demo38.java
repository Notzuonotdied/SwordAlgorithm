package SwordOffer.JavaOffer;

import LeetCode.Java.component.TreeNode;

public class Demo38 {

    public static void main(String[] args) {

    }

    private static class Solution1 {

        private static int depth = 1;

        public int TreeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            CalTreeDepth(root);
            return depth;
        }

        private void CalTreeDepth(TreeNode root) {
            if (root.left == null && root.right == null) {
                depth += 1;
                return;
            }

            if (root.left != null) {
                TreeDepth(root.left);
            }

            if (root.right != null) {
                TreeDepth(root.right);
            }
        }
    }

    private static class Solution2 {
        public int TreeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = TreeDepth(root.left);
            int rightDepth = TreeDepth(root.right);

            return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
        }
    }
}
