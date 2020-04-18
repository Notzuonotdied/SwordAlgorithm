package LeetCode.Java;

public class MergeKLists {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
         *
         * 示例:
         *
         * 输入:
         * [
         *   1->4->5,
         *   1->3->4,
         *   2->6
         * ]
         * 输出: 1->1->2->3->4->4->5->6
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }

            return merge(lists, 0, lists.length - 1);
        }

        private ListNode merge(ListNode[] listNodes, int start, int end) {
            if (start == end) return listNodes[start];
            int mid = (start + end) >> 1;
            ListNode listNodeLeft = merge(listNodes, start, mid);
            ListNode listNodeRight = merge(listNodes, mid + 1, end);
            return merge(listNodeLeft, listNodeRight);
        }

        private ListNode merge(ListNode listNodeLeft, ListNode listNodeRight) {
            if (listNodeLeft == null && listNodeRight == null) {
                return null;
            }
            if (listNodeLeft == null) {
                return listNodeRight;
            }
            if (listNodeRight == null) {
                return listNodeLeft;
            }
            if (listNodeLeft.val <= listNodeRight.val) {
                listNodeLeft.next = merge(listNodeLeft.next, listNodeRight);
                return listNodeLeft;
            } else {
                listNodeRight.next = merge(listNodeLeft, listNodeRight.next);
                return listNodeRight;
            }
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
