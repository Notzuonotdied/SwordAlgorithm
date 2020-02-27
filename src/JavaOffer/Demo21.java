package JavaOffer;

import java.util.Stack;

public class Demo21 {

    public static void main(String[] args) {
        boolean isOk = IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
        System.out.println(isOk);
    }

    /**
     * 方法：data1数组的顺序表示入栈的顺序。现在判断data2的这种出栈顺序是否正确
     */
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        // 这里需要用到辅助栈
        Stack<Integer> stack = new Stack<>();

        for (int i = 0, j = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            System.out.println("pushA[i] -> " + pushA[i]);

            // 判断栈顶是否和弹出栈一致，一致就直接弹出。
            while (stack.size() > 0 && stack.peek() == popA[j]) {
                System.out.println("popA[j] -> " + popA[j]);
                stack.pop();
                j++;
            }
        }
        return stack.size() == 0;
    }
}
