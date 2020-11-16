package LeetCode.Java.backtrace;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
         *
         * 示例：
         *
         * 输入：n = 3
         * 输出：[
         *        "((()))",
         *        "(()())",
         *        "(())()",
         *        "()(())",
         *        "()()()"
         *      ]
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/generate-parentheses
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            StringBuilder cur = new StringBuilder();
            backtrace(ans, cur, 0, 0, n);
            return ans;
        }

        private void backtrace(List<String> ans, StringBuilder cur, int open, int close, int max) {
            // 因为左右括号，所有需要两倍
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            if (open < max) {
                cur.append('(');
                backtrace(ans, cur, open + 1, close, max);
                cur.deleteCharAt(cur.length() - 1);
            }
            // 确保右括号的数量要等于左括号的数量
            if (close < open) {
                cur.append(')');
                backtrace(ans, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}
