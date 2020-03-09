package JavaOffer;

public class Demo36 {
    public static void main(String[] args) {

    }

    private static class Solution {
        public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            ListNode p1 = pHead1;
            ListNode p2 = pHead2;
            while (p1 != p2) {
                p1 = (p1 == null ? pHead2 : p1.next);
                p2 = (p2 == null ? pHead1 : p2.next);
            }
            return p1;
        }
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
