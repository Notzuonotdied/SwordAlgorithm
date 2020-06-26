package SwordOffer.JavaOffer;

public class Demo14 {

    public static void main(String[] args) {
        ListNode rootNode = new ListNode(0);
        ListNode tempNode = rootNode;
        for (int i = 1; i <= 10; ++i) {
            ListNode nextNode = new ListNode(i);
            tempNode.next = nextNode;
            tempNode = nextNode;
        }
        int k = 6;
        ListNode result = FindKthToTail(rootNode, k);
        System.out.println(result != null ? "倒数第" + k + "个节点的数据为：" + result.val : "找不到数据");
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        // 输入的链表不能为空，并且k大于0
        if (k < 1 || head == null) {
            return null;
        }

        // 指向头结点
        ListNode pointer = head;

        // 倒数第k个结点与倒数第一个结点相隔k-1个位置
        // pointer先走k-1个位置
        for (int i = 1; i < k; i++) {
            // 说明还有结点
            if (pointer.next != null) {
                pointer = pointer.next;
            }
            // 已经没有节点了，但是i还没有到达k-1说明k太大，链表中没有那么多的元素
            else {
                // 返回结果
                return null;
            }

        }

        // pointer还没有走到链表的末尾，那么pointer和head一起走，
        // 当pointer走到最后一个结点即，pointer.next=null时，head就是倒数第k个结点
        while (pointer.next != null) {
            head = head.next;
            pointer = pointer.next;
        }

        // 返回结果
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
