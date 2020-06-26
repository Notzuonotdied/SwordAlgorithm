package LeetCode.Java;

public class SortList {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
         * <p>
         * https://leetcode-cn.com/problems/sort-list/
         * <p>
         * 题解：https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
         */
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 找到中位
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 切断链表
            ListNode tmp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(tmp);
            // 排序链表
            ListNode h = new ListNode(0);
            ListNode res = h;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
                h = h.next;
            }
            h.next = left != null ? left : right;
            return res.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
