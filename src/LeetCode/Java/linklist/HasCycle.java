package LeetCode.Java.linklist;

import common.java.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    public static void main(String[] args) {

    }

    private interface ICycle {
        boolean hasCycle(ListNode head);
    }

    public static class Solution1 implements ICycle {
        /**
         * 给你一个链表的头节点 head ，判断链表中是否有环。
         * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
         * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
         * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
         * 如果链表中存在环，则返回 true 。 否则，返回 false 。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/linked-list-cycle
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：39.1 MB, 在所有 Java 提交中击败了86.41% 的用户
         */
        @Override
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = slow.next;

            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }

    private static class Solution2 implements ICycle {

        /**
         * 执行用时：6 ms, 在所有 Java 提交中击败了11.44% 的用户
         * 内存消耗：38.9 MB, 在所有 Java 提交中击败了94.13% 的用户
         */
        @Override
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            Set<ListNode> tmp = new HashSet<>();
            while (head != null) {
                if (tmp.contains(head)) {
                    return false;
                }
                tmp.add(head);
                head = head.next;
            }
            return true;
        }
    }
}
