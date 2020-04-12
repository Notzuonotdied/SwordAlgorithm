package LeetCode.Java;

public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    private static class Solution {
        /**
         * 题目：编写一个程序，找到两个单链表相交的起始节点。
         * 具体描述详见：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
         * <p>
         * 可以查看下述题解：
         * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
         *
         * @see JavaOffer.Demo55 这个题目和`列表中找环的入口节点`的题目思路一致。
         */
        public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            ListNode pA = headA;
            ListNode pB = headB;

            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
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
