package LiHuaQiang.A2_LinkeList;

import common.java.ListNode;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        // 1 2
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(2);
        System.out.println(new Solution1().isPalindrome(root1));
        // 1 2 2 1
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(2);
        root2.next.next = new ListNode(2);
        root2.next.next.next = new ListNode(1);
        System.out.println(new Solution1().isPalindrome(root2));
        // 1 2 3 2 1
        ListNode root3 = new ListNode(1);
        root3.next = new ListNode(2);
        root3.next.next = new ListNode(3);
        root3.next.next.next = new ListNode(2);
        root3.next.next.next.next = new ListNode(1);
        System.out.println(new Solution1().isPalindrome(root3));
        // 1 2 3 4 2 1
        ListNode root4 = new ListNode(1);
        root4.next = new ListNode(2);
        root4.next.next = new ListNode(3);
        root4.next.next.next = new ListNode(4);
        root4.next.next.next.next = new ListNode(2);
        root4.next.next.next.next.next = new ListNode(1);
        System.out.println(new Solution1().isPalindrome(root4));
    }

    private interface IPalindrome {
        boolean isPalindrome(ListNode head);
    }

    private static class Solution1 implements IPalindrome {

        /**
         * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
         * <p>
         * 示例 1：
         * 输入：head = [1,2,2,1]
         * 输出：true
         * <p>
         * 示例 2：
         * 输入：head = [1,2]
         * 输出：false
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * 时间复杂度Tn：O(n) - O(lgn)
         * 空间复杂度Sn：O()
         */
        @Override
        public boolean isPalindrome(ListNode head) {
            // 1.快慢指针，将链表分为两半
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode list1 = head;
            // 2.翻转链表，翻转后半部分链表
            ListNode previousNode = null, currentNode = slow.next, lastNode;
            while (currentNode != null) {
                lastNode = currentNode.next;
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = lastNode;
            }
            ListNode list2 = previousNode;
            ListNode list2Head = previousNode;
            boolean result = true;
            // 3.翻转后的链表两端分别向中心移动，如果结点值有不同的情况则不是回文链表
            while (list2 != null) {
                if (list1.val != list2.val) {
                    result = false;
                    break;
                }
                list1 = list1.next;
                list2 = list2.next;
            }
            // 4.复原链表
            ListNode previousNode1 = null, currentNode1 = list2Head, lastNode1 = list2Head.next;
            while (currentNode1 != null) {
                lastNode1 = currentNode1.next;
                currentNode1.next = previousNode1;
                previousNode1 = currentNode1;
                currentNode1 = lastNode1;
            }
            // 打印复原后的链表
            StringBuilder sb2 = new StringBuilder();
            ListNode temp2 = head;
            while (temp2 != null) {
                sb2.append(temp2.val);
                temp2 = temp2.next;
            }
            System.out.println("复原后：" + sb2.toString());
            return result;
        }
    }
}
