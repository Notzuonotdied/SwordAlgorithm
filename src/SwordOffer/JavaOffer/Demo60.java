package SwordOffer.JavaOffer;

import LeetCode.Java.component.TreeNode;

import java.util.ArrayList;

public class Demo60 {
    public static void main(String[] args) {

    }

    public static class Solution {
        ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            depth(pRoot, 1, list);
            return list;
        }

        private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
            if (root == null) return;
            if (depth > list.size())
                list.add(new ArrayList<>());
            list.get(depth - 1).add(root.val);

            depth(root.left, depth + 1, list);
            depth(root.right, depth + 1, list);
        }
    }
}
