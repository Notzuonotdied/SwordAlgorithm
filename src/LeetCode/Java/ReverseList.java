package LeetCode.Java;

import common.java.ListNode;

public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);


        ListNode reverseHead = Solution1.reverseList(head);
        printListNode(reverseHead);
    }

    private static class Solution1 {
        /**
         * 反转一个单链表。
         * <p>
         * https://leetcode-cn.com/problems/reverse-linked-list/
         */
        public static ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }
    }

    private static void printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(' ');
            head = head.next;
        }
        System.out.println(sb.toString());
    }
}
