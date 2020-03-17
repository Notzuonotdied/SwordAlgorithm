package JavaOffer;

public class Demo52 {
    public static void main(String[] args) {

    }

    public static class Solution1 {
        public static boolean matchStr(char[] str, int i, char[] pattern, int j) {
            // 边界
            if (i == str.length && j == pattern.length) { // 字符串和模式串都为空
                return true;
            } else if (j == pattern.length) { // 模式串为空
                return false;
            }

            boolean next = (j + 1 < pattern.length && pattern[j + 1] == '*'); // 模式串下一个字符是'*'
            if (next) {
                if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) { // 要保证i<str.length，否则越界
                    return matchStr(str, i, pattern, j + 2) || matchStr(str, i + 1, pattern, j);
                } else {
                    return matchStr(str, i, pattern, j + 2);
                }
            } else {
                if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) {
                    return matchStr(str, i + 1, pattern, j + 1);
                } else {
                    return false;
                }
            }
        }

        public static boolean match(char[] str, char[] pattern) {
            return matchStr(str, 0, pattern, 0);
        }
    }
}
