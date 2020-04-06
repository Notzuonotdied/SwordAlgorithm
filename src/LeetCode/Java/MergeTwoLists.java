package LeetCode.Java;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(7);

        ListNode mergeHead = Solution1.mergeTwoLists(head1, head2);
        StringBuilder sb = new StringBuilder();
        while (mergeHead != null) {
            sb.append(mergeHead.val);
            mergeHead = mergeHead.next;
        }
        System.out.println(sb.toString());
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    private static class Solution1 {
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode root = new ListNode(-1);
            ListNode head = root;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    head.next = l1;
                    l1 = l1.next;
                } else {
                    head.next = l2;
                    l2 = l2.next;
                }
                head = head.next;
            }
            head.next = l1 == null ? l2 : l1;
            return root.next;
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
