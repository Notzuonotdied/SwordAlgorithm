package JavaOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Demo24 {
    //        13
    //    10      11
    //  6   7    8
    // 1 2 3 4  5 9
    public static void main(String[] args) {
        TreeNode root = new TreeNode(13);

        // 13
        root.left = new TreeNode(10);
        root.right = new TreeNode(11);

        // 10
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);

        // 11
        root.right.left = new TreeNode(8);

        // 6
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(2);

        // 7
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(4);

        // 8
        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(9);

        printTree(root);
        System.out.println(FindPath(root, 30));
    }

    private static Queue<TreeNode> queue = new LinkedList<>();
    private static ArrayList<Integer> result = new ArrayList<>();

    /**
     * 输出二叉树的层级结构
     */
    private static void printTree(TreeNode treeNode) {
        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                continue;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            result.add(node.val);
        }
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private static ArrayList<Integer> path = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }

        FindPath(root, target, 0);
        return res;
    }

    public static void FindPath(TreeNode root, int target, int sum) {
        path.add(root.val);

        sum += root.val;

        if (sum == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }

        if (root.left != null) {
            FindPath(root.left, target, sum);
        }

        if (root.right != null) {
            FindPath(root.right, target, sum);
        }

        path.remove(path.size() - 1);
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
