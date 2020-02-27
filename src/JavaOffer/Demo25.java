package JavaOffer;

public class Demo25 {
    // https://www.nowcoder.com/questionTerminal/f836b2c43afc4b35ad6adc41ec941dba?commentTags=Java
    public static void main(String[] args) {

    }

    /**
     * 在原链表上进行复制，然后拆分
     * 分为三步：
     * 1.复制,复制当前节点插入到其后面，此时不处理新链表的random
     * 2.处理random，根据原链表的random，处理新链表的兄random
     * 3.从原链表中拆分出来新链表
     */
    //解题思路：1.遍历链表，如复制A节点A1插入到A后面
    //        2.再次遍历链表，A1.random = A.random.next
    //        3.拆分链表，将链表拆分为原链表和复制后的新链表
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode head = pHead;
        RandomListNode node; //临时指针
        RandomListNode nextNode;
        // 1.复制
        while (head != null) {
            node = new RandomListNode(head.label);
            nextNode = head.next;
            head.next = node;
            node.next = nextNode;
            head = head.next.next;
        }
        // 2.处理random
        head = pHead; //head指向头
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        // 3.拆分
        head = pHead;
        RandomListNode new_pHead = pHead.next;
        node = new_pHead;
        while (head != null) {
            head.next = node.next;
            if (node.next != null) {
                node.next = node.next.next;
            }
            node = node.next;
            head = head.next;
        }
        return new_pHead;
    }

    private static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
