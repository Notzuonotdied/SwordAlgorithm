package LeetCode.Java;

public class RotateRight {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        printLinkList(Solution1.rotateRight(root, 1));
    }

    private static class Solution1 {
        /**
         * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
         * <p>
         * https://leetcode-cn.com/problems/rotate-list/
         */
        public static ListNode rotateRight(ListNode head, int k) {
            // base case
            if (head == null) return null;
            if (head.next == null) return head;

            ListNode oldTail = head;
            int n;
            for (n = 1; oldTail.next != null; n++) {
                oldTail = oldTail.next;
            }
            oldTail.next = head;

            // find new tail : (n - k % n - 1)th node
            // and new head : (n - k % n)th node
            ListNode newTail = head;
            for (int i = 0; i < n - k % n - 1; i++) {
                newTail = newTail.next;
            }
            ListNode newHead = newTail.next;

            // break the ring
            newTail.next = null;

            return newHead;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void printLinkList(ListNode root) {
        StringBuilder sb = new StringBuilder();
        while (root != null) {
            sb.append(root.val);
            root = root.next;
        }
        System.out.println(sb.toString());
    }

}
