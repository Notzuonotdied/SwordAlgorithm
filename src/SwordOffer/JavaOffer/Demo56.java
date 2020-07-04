package SwordOffer.JavaOffer;

import common.java.ListNode;

public class Demo56 {
    public static void main(String[] args) {

    }

    public static class Solution1 {
        /**
         * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
         * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
         * <p>
         * 关键字：「排序」「重复」「删除」
         */
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null || pHead.next == null) return pHead;
            // 因为头结点可能被删除，因此需要增加一个节点
            ListNode tempHead = new ListNode(0);
            tempHead.next = pHead;

            ListNode pre = tempHead;
            ListNode last = tempHead.next;
            while (last != null) {
                if (last.next != null && last.val == last.next.val) {
                    // 找到最后一个相同的value
                    while (last.next != null && last.val == last.next.val) {
                        last = last.next;
                    }
                    pre.next = last.next;
                } else {
                    pre = pre.next;
                }
                last = last.next;
            }
            return tempHead.next;
        }
    }
}
