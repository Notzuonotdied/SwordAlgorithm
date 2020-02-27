package JavaOffer;

public class Demo15 {

    public static void main(String[] args) {
        ListNode rootNode = new ListNode(0);
        ListNode tempNode = rootNode;
        for (int i = 1; i <= 10; ++i) {
            ListNode nextNode = new ListNode(i);
            tempNode.next = nextNode;
            tempNode = nextNode;
        }
        System.out.println("初始数据：");
        printListNode(rootNode);
        ListNode result = ReverseList(rootNode);
        System.out.println("调整后数据：");
        printListNode(result);
    }

    private static void printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(' ');
            head = head.next;
        }
        System.out.println(sb.toString());
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        head.next = null;
        head = pre;
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
