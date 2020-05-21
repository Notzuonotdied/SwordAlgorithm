package LeetCode.Java;

import java.util.Stack;

public class ParseBoolExpr {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
         *
         * 有效的表达式需遵循以下约定：
         *
         *     "t"，运算结果为 True
         *     "f"，运算结果为 False
         *     "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
         *     "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
         *     "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/parsing-a-boolean-expression
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 思路：
         *      模仿后缀表达式求值，使用双栈的方式解决
         *      https://leetcode-cn.com/problems/parsing-a-boolean-expression/solution/cmo-fang-hou-zhui-biao-da-shi-qiu-zhi-shuang-zhan-/
         *
         *      执行用时 :14 ms, 在所有 Java 提交中击败了53.89% 的用户
         *      内存消耗 :39.8 MB, 在所有 Java 提交中击败了33.33%的用户
         */
        public static boolean parseBoolExpr(String expression) {
            Stack<Character> opStack = new Stack<>();
            Stack<Character> valueStack = new Stack<>();

            char ch;
            int tNums, fNums;
            for (int i = 0; i < expression.length(); ++i) {
                ch = expression.charAt(i);
                if (ch == '!' || ch == '&' || ch == '|') {
                    opStack.push(ch);
                } else if (ch == ')') {
                    // 执行逻辑
                    tNums = 0;
                    fNums = 0;
                    while (valueStack.peek() != '(') {
                        ch = valueStack.pop();
                        if (ch == 't') {
                            tNums++;
                        }
                        if (ch == 'f') {
                            fNums++;
                        }
                    }
                    // 弹出'('
                    valueStack.pop();
                    // 逻辑符
                    switch (opStack.pop()) {
                        case '!':
                            valueStack.push(tNums == 1 ? 'f' : 't');
                            break;
                        case '&':
                            valueStack.push(fNums != 0 ? 'f' : 't');
                            break;
                        case '|':
                            valueStack.push(tNums != 0 ? 't' : 'f');
                            break;
                        default:
                            break;
                    }
                } else {
                    valueStack.push(ch);
                }
            }
            return valueStack.pop() == 't';
        }
    }
}
