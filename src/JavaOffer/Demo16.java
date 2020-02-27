package JavaOffer;

public class Demo16 {

    public static void main(String[] args) {
        ListNode firstNode = createListNode(new int[]{1, 3, 5, 7, 9});
        ListNode secNode = createListNode(new int[]{2, 4, 6, 8});
        System.out.println("初始数据：");
        printListNode(firstNode);
        printListNode(secNode);
        System.out.println("调整后数据：");
        printListNode(Merge(firstNode, secNode));
    }

    private static ListNode createListNode(int[] valList) {
        if (valList == null || valList.length == 0) {
            return null;
        }
        ListNode rootNode = new ListNode(valList[0]);
        ListNode tempNode = rootNode;
        for (int i = 1; i < valList.length; ++i) {
            ListNode nextNode = new ListNode(valList[i]);
            tempNode.next = nextNode;
            tempNode = nextNode;
        }
        return rootNode;
    }

    private static void printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(' ');
            head = head.next;
        }
        System.out.println(sb.toString());
    }

    public static ListNode Merge(ListNode head1, ListNode head2) {
        // 如果第一个链表为空，返回第二个链表头结点
        if (head1 == null) {
            return head2;
        }

        // 如果第二个结点为空，返回第一个链表头结点
        if (head2 == null) {
            return head1;
        }

        // 创建一个临时结点，用于添加元素时方便
        ListNode root = new ListNode(0);
        // 用于指向合并后的新链的尾结点
        ListNode pointer = root;

        // 当两个链表都不为空就进行合并操作
        while (head1 != null && head2 != null) {
            // 下面的操作合并较小的元素
            if (head1.val < head2.val) {
                pointer.next = head1;
                head1 = head1.next;
            } else {
                pointer.next = head2;
                head2 = head2.next;
            }

            // 将指针移动到合并后的链表的末尾
            pointer = pointer.next;
        }

        // 下面的两个if有且只一个if会内的内容会执行

        // 如果第一个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head1 != null) {
            pointer.next = head1;
        }

        // 如果第二个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head2 != null) {
            pointer.next = head2;
        }

        // 返回处理结果
        return root.next;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
