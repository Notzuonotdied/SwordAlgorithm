package JavaOffer;

public class Demo55 {
    public static void main(String[] args) {

    }

    public static class Solution1 {
        /**
         * 可以使用快慢指针（一个走一步，一个走两步），当他们相遇的时候，刚好是环的一半
         */
        public ListNode EntryNodeOfLoop(ListNode pHead) {
            ListNode fast = pHead;
            ListNode slow = pHead;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow)
                    break;
            }
            if (fast == null || fast.next == null)
                return null;
            fast = pHead;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
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
