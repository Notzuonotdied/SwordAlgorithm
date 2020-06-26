package SwordOffer.JavaOffer;

import java.util.Stack;

public class Demo20 {
    /**
     * 包含min函数的栈
     */
    public static void main(String[] args) {

    }

    private Stack<Integer> st1 = new Stack<>();
    private Stack<Integer> st2 = new Stack<>();
    private Integer tem = null;

    public void push(int node) {
        if (tem != null) {
            if (node <= tem) {
                tem = node;
                st1.push(node);
                st2.push(node);
            } else {
                st1.push(node);
                st2.push(tem);
            }
        } else {
            tem = node;
            st1.push(node);
            st2.push(node);
        }
    }

    public void pop() {
        if (!st1.empty() && !st2.empty()) {
            int m = st1.pop();
            st2.pop();
            tem = m;
        }
    }

    public int top() {
        int top = st1.pop();
        st1.push(top);
        return top;
    }

    public int min() {
        int min = st2.pop();
        st2.push(min);
        return min;
    }
}
