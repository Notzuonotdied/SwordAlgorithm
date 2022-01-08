package LeetCode.Java.linklist;

import common.java.ListNode;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        // 1 2
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(2);
        System.out.println(new Solution1().isPalindrome(root1));
        // 1 2 3 2 1
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(2);
        root2.next.next = new ListNode(2);
        root2.next.next.next = new ListNode(1);
        System.out.println(new Solution1().isPalindrome(root2));
    }

    private interface IPalindrome {
        boolean isPalindrome(ListNode head);
    }

    private static class Solution1 implements IPalindrome {

        /**
         * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
         * 示例 1：
         * 输入：head = [1,2,2,1]
         * 输出：true
         * 示例 2：
         * 输入：head = [1,2]
         * 输出：false
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：6 ms, 在所有 Java 提交中击败了60.37% 的用户
         * 内存消耗：48 MB, 在所有 Java 提交中击败了95.41% 的用户
         */
        @Override
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            // 找到前半部分链表的尾节点并反转后半部分链表
            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStart = reverseList(firstHalfEnd.next);

            // 判断是否回文
            ListNode p1 = head;
            ListNode p2 = secondHalfStart;
            boolean result = true;
            while (result && p2 != null) {
                if (p1.val != p2.val) {
                    result = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            // 还原链表并返回结果
            firstHalfEnd.next = reverseList(secondHalfStart);
            return result;
        }

        /**
         * 链表反转
         *
         * @param head 根节点
         */
        private ListNode reverseList(ListNode head) {
            ListNode prev = null, curr = head, nextTemp;
            while (curr != null) {
                nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        /**
         * 使用快慢指针，找到链表的中间位置
         *
         * @param head 根节点
         */
        private ListNode endOfFirstHalf(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
