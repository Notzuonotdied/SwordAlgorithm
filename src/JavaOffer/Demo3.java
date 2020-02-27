package JavaOffer;

import java.util.ArrayList;

import java.util.Stack;


public class Demo3 {

    public static void main(String[] args) {
        ListNode rootNode = new ListNode(0);
        ListNode tempNode = rootNode;
        for (int i = 1; i <= 10; ++i) {
            ListNode nextNode = new ListNode(i);
            tempNode.next = nextNode;
            tempNode = nextNode;
        }
        System.out.println(printListFromTailToHead(rootNode).toString());
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>(0);
        }
        Stack<ListNode> nodeStack = new Stack<>();
        while (listNode != null) {
            nodeStack.push(listNode);
            listNode = listNode.next;
        }
        ArrayList<Integer> vals = new ArrayList<>();
        while (!nodeStack.isEmpty()) {
            vals.add(nodeStack.pop().val);
        }
        return vals;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}



