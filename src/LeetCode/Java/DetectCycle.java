package LeetCode.Java;

import common.java.ListNode;

public class DetectCycle {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
         * <p>
         * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
         * <p>
         * 说明：不允许修改给定的链表。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 具体思路详见：
         * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
         */
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            do {
                if (fast == null || fast.next == null) {
                    return null;
                }
                slow = slow.next;
                fast = fast.next.next;
            } while (slow != fast);

            fast = head;
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
    }
}
