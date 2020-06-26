package SwordOffer.JavaOffer;

import java.util.Stack;

public class Demo5 {

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5();

        demo5.push(1);
        demo5.push(2);
        demo5.push(3);

        System.out.println(demo5.pop());
        System.out.println(demo5.pop());
        System.out.println(demo5.pop());
    }

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        // 先判断弹出栈是否为空，如果为空就将插入栈的所有数据弹出栈，
        // 并且将弹出的数据压入弹出栈中
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }

        // 如果弹出栈中还没有数据就抛出异常
        if (stack2.isEmpty()) {
            throw new RuntimeException("No more element.");
        }

        // 返回弹出栈的栈顶元素，对应的就是队首元素。
        return stack2.pop();
    }
}
