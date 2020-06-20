package SwordOffer.JavaOffer;

import LeetCode.Java.component.TreeNode;

public class Demo18 {

    public static void main(String[] args) {

    }

    public void Mirror(TreeNode root) {
        // 如果当前结点不为空则进行操作
        if (root != null) {
            // 下面是交换结点左右两个子树
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            // 对结点的左右两个子树进行处理
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
