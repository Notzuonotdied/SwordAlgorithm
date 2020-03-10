package JavaOffer;

public class Demo39 {

    public static void main(String[] args) {

    }

    private static class Solution1 {
        public static boolean IsBalanced_Solution(TreeNode root) {
            if (root == null) {
                return true;
            }
            // 重复计算了节点
            int left = TreeDepth(root.left);
            int right = TreeDepth(root.right);
            int diff = left - right;
            if (diff > 1 || diff < -1) {
                return false;
            }

            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }

        private static int TreeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = TreeDepth(root.left);
            int rightDepth = TreeDepth(root.right);

            return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
        }
    }

    private static class Solution2 {
        public static boolean IsBalanced_Solution(TreeNode root) {
            return getDepth(root) != -1;
        }

        private static int getDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = getDepth(root.left);
            // 剪枝
            if (left == -1) {
                return -1;
            }
            int right = getDepth(root.right);
            // 剪枝
            if (right == -1) {
                return -1;
            }
            // 计算高度
            return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
