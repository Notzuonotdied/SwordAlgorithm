package LeetCode.Java.linklist;

public class CopyRandomList {

    public static void main(String[] args) {

    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private static class Solution1 {
        /**
         * 基于原链表复制一个新的链表出来
         * 思路：复制原节点并插入到原节点后边 -> 复制random -> 拆分链表
         * <p>
         * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/jian-zhi-offer-35-fu-za-lian-biao-de-fu-zhi-ha-xi-/
         * <p>
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：37.9 MB, 在所有 Java 提交中击败了96.65% 的用户
         */
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node cur = head;
            // 1. 复制各节点，并构建拼接链表
            while (cur != null) {
                Node tmp = new Node(cur.val);
                tmp.next = cur.next;
                cur.next = tmp;
                cur = tmp.next;
            }
            // 2. 构建各新节点的 random 指向
            cur = head;
            while (cur != null) {
                if (cur.random != null) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }
            // 3. 拆分两链表
            cur = head.next;
            Node pre = head, res = head.next;
            while (cur.next != null) {
                pre.next = pre.next.next;
                cur.next = cur.next.next;
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = null; // 单独处理原链表尾节点
            return res;      // 返回新链表头节点
        }
    }
}
