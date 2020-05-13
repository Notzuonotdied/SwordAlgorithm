package LeetCode.Java;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = Solution1.removeNthFromEnd(head, 2);

        StringBuilder sb = new StringBuilder();
        while (result != null) {
            sb.append(result.val);
            result = result.next;
        }
        System.out.println(sb.toString());
    }

    private static class Solution1 {
        /**
         * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
         * <p>
         * n 大于 链表的长度 -> 不处理
         * n 等于 链表的长度 -> 去掉头结点
         * n 小于 链表的长度 -> 去掉指定结点，返回头结点
         */
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode first = dummy;
            ListNode second = dummy;
            for (int i = 1; i <= n + 1; i++) {
                first = first.next;
            }
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return dummy.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
