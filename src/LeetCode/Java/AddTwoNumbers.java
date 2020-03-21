package LeetCode.Java;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode head = Solution1.addTwoNumbers(l1, l2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static class Solution1 {
        /**
         * 几种情况：
         * <p>
         * ---1
         * 1 6 3
         * 3 4 5
         * <p>
         * ---2
         * 5
         * 5
         * <p>
         * ---3
         * 9 8
         * 1
         * <p>
         * ---4
         * 9 9
         * 1
         */
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return new ListNode(0);
            } else if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            }

            ListNode head = new ListNode(0);
            ListNode point = head;
            boolean isCarry = false;
            while (l1 != null && l2 != null) {
                int curSum = l1.val + l2.val;
                if (isCarry) {
                    ++curSum;
                    isCarry = false;
                }
                if (curSum > 9) {
                    curSum -= 10;
                    isCarry = true;
                }
                point.next = new ListNode(curSum);
                point = point.next;

                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                if (isCarry) {
                    int temp = l1.val + 1;
                    isCarry = temp > 9;
                    if (isCarry) {
                        temp -= 10;
                    }
                    point.next = new ListNode(temp);
                } else {
                    point.next = l1;
                }
                point = point.next;
                l1 = l1.next;
            }

            while (l2 != null) {
                if (isCarry) {
                    int temp = l2.val + 1;
                    isCarry = temp > 9;
                    if (isCarry) {
                        temp -= 10;
                    }
                    point.next = new ListNode(temp);
                } else {
                    point.next = l2;
                }
                point = point.next;
                l2 = l2.next;
            }
            if (isCarry) {
                point.next = new ListNode(1);
            }
            return head.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
