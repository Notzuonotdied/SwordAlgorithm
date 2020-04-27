package SwordOffer.JavaOffer;

public class Demo17 {

    public static void main(String[] args) {

    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        // 只要树B的根结点点为空就返回true
        if (root2 == null) {
            return false;
        }

        // 树B的根结点不为空，如果树A的根结点为空就返回false
        if (root1 == null) {
            return false;
        }

        // 只要两个对象是同一个就返回true
        if (root1 == root2) {
            return true;
        }

        // 记录匹配结果
        boolean result = false;

        // 如果结点的值相等就，调用匹配方法
        if (root1.val == root2.val) {
            result = match(root1, root2);
        }

        // 如果匹配就直接返回结果
        if (result) {
            return true;
        }

        // 如果不匹配就找树A的左子结点和右子结点进行判断
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private static boolean match(TreeNode root1, TreeNode root2) {
        // 只要两个对象是同一个就返回true
        if (root1 == root2) {
            return true;
        }

        // 只要树B的根结点点为空就返回true
        if (root2 == null) {
            return true;
        }
        // 树B的根结点不为空，如果树A的根结点为空就返回false
        if (root1 == null) {
            return false;
        }

        // 如果两个结点的值相等，则分别判断其左子结点和右子结点
        if (root1.val == root2.val) {
            return match(root1.left, root2.left) && match(root1.right, root2.right);
        }

        // 结点值不相等返回false
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
