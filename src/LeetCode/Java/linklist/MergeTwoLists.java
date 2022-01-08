package LeetCode.Java.linklist;

import common.java.ListNode;

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
        System.out.println(sb);
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例 1：
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了23.94% 的用户
     */
    private static class Solution1 {
        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode root = new ListNode(-1);
            ListNode head = root;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    head.next = list1;
                    list1 = list1.next;
                } else {
                    head.next = list2;
                    list2 = list2.next;
                }
                head = head.next;
            }
            head.next = list1 == null ? list2 : list1;
            return root.next;
        }
    }
}
