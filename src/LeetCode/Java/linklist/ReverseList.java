package LeetCode.Java.linklist;

import common.java.ListNode;

public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);


        ListNode reverseHead = new Solution1().reverseList(head);
        printListNode(reverseHead);
    }

    private static void printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(' ');
            head = head.next;
        }
        System.out.println(sb);
    }

    private interface ISolution {
        ListNode reverseList(ListNode head);
    }

    private static class Solution1 implements ISolution {
        /**
         * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
         * 示例 1：
         * 输入：head = [1,2,3,4,5]
         * 输出：[5,4,3,2,1]
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/reverse-linked-list
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：37.9 MB, 在所有 Java 提交中击败了90.48% 的用户
         */
        public ListNode reverseList(ListNode head) {
            ListNode pre = null, cur = head, tmp;
            while (cur != null) {
                tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }
}
