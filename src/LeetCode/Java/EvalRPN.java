package LeetCode.Java;

import java.util.Stack;

public class EvalRPN {
    public static void main(String[] args) {

    }

    private static class Solution1 {

        /**
         * 根据逆波兰表示法，求表达式的值。
         * <p>
         * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
         * <p>
         * 说明：
         * <p>
         * 整数除法只保留整数部分。
         * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 思路：
         * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/solution/javachun-shu-zu-he-zhan-liang-chong-shi-xian-jian-/
         */
        public static int evalRPN(String[] tokens) {
            Stack<Integer> numStack = new Stack<>();
            Integer op1, op2;
            for (String s : tokens) {
                switch (s) {
                    case "+":
                        op2 = numStack.pop();
                        op1 = numStack.pop();
                        numStack.push(op1 + op2);
                        break;
                    case "-":
                        op2 = numStack.pop();
                        op1 = numStack.pop();
                        numStack.push(op1 - op2);
                        break;
                    case "*":
                        op2 = numStack.pop();
                        op1 = numStack.pop();
                        numStack.push(op1 * op2);
                        break;
                    case "/":
                        op2 = numStack.pop();
                        op1 = numStack.pop();
                        numStack.push(op1 / op2);
                        break;
                    default:
                        numStack.push(Integer.valueOf(s));
                        break;
                }
            }
            return numStack.pop();
        }
    }
}
