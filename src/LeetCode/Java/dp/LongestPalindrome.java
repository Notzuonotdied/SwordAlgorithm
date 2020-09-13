package LeetCode.Java.dp;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new Solution1().longestPalindrome("bb"));
    }

    private static class Solution1 {
        /**
         * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
         *
         * 示例 1：
         *
         * 输入: "babad"
         * 输出: "bab"
         * 注意: "aba" 也是一个有效答案。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            int strLen = s.length();
            int maxStart = 0;   //最长回文串的起点
            int maxEnd = 0;     //最长回文串的终点
            int maxLen = 1;     //最长回文串的长度

            boolean[][] dp = new boolean[strLen][strLen];
            for (int r = 1; r < strLen; r++) {
                for (int l = 0; l < r; l++) {
                    if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                        dp[l][r] = true;
                        if (r - l + 1 <= maxLen) {
                            continue;
                        }
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
            return s.substring(maxStart, maxEnd + 1);
        }
    }

    private static class Solution2 {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            int maxStart = 0;
            int maxEnd = 0;
            int maxLen = 1;

            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int r = 1; r < s.length(); ++r) {
                for (int l = 0; l < r; ++l) {
                    if (s.charAt(l) != s.charAt(r)) {
                        continue;
                    }
                    if (r - l > 2 && !dp[l + 1][r - 1]) {
                        continue;
                    }
                    dp[l][r] = true;
                    if (r - l + 1 <= maxLen) {
                        continue;
                    }
                    maxStart = l;
                    maxEnd = r;
                    maxLen = maxEnd - maxStart + 1;
                }
            }
            return s.substring(maxStart, maxEnd + 1);
        }
    }
}
