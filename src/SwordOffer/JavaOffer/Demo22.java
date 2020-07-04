package SwordOffer.JavaOffer;

import common.java.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Demo22 {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        // 当结点非空时才进行操作
        if (root == null) {
            return result;
        }

        // 用于存放还未遍历的元素
        Queue<TreeNode> list = new LinkedList<>();
        // 将根结点入队
        list.add(root);
        // 用于记录当前处理的结点
        TreeNode curNode;

        // 队列非空则进行处理
        while (!list.isEmpty()) {
            // 删除队首元素
            curNode = list.remove();
            // 输出队首元素的值
            result.add(curNode.val);
            // 如果左子结点不为空，则左子结点入队
            if (curNode.left != null) {
                list.add(curNode.left);
            }
            // 如果右子结点不为空，则左子结点入队
            if (curNode.right != null) {
                list.add(curNode.right);
            }
        }
        return result;
    }
}
