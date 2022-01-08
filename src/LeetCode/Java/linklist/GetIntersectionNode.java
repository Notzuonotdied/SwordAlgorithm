package LeetCode.Java.linklist;

import common.java.ListNode;

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
         * @see SwordOffer.JavaOffer.Demo55 这个题目和`列表中找环的入口节点`的题目思路一致。
         * <p>
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.98% 的用户
         * 内存消耗：41.2 MB, 在所有 Java 提交中击败了54.48% 的用户
         */
        public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            ListNode pA = headA;
            ListNode pB = headB;

            // 具体请看题目给的说明：
            // A链表长度5，B链表长度6
            // a1 a2 c1 c2 c3 b1 b2 b3 c1(5 + 3 + 1 = 9)
            // b1 b2 b3 c1 c2 c3 a1 a2 c1(6 + 2 + 1 = 9)
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
    }
}
