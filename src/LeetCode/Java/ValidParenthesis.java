package LeetCode.Java;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(Solution1.isValid(")("));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * * * 左括号必须用相同类型的右括号闭合。
     * * * 左括号必须以正确的顺序闭合。
     * <p>
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.90% 的用户
     * 内存消耗：36.5 MB, 在所有 Java 提交中击败了52.99% 的用户
     */
    private static class Solution1 {
        public static boolean isValid(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }
            Stack<Character> backup = new Stack<>();
            for (char ch : s.toCharArray()) {
                if (ch == '{') {
                    backup.push('}');
                    continue;
                }
                if (ch == '[') {
                    backup.push(']');
                    continue;
                }
                if (ch == '(') {
                    backup.push(')');
                    continue;
                }
                if (backup.size() == 0 || ch != backup.pop()) {
                    return false;
                }
            }
            return backup.isEmpty();
        }
    }
}
