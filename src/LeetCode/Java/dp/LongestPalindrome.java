package LeetCode.Java.dp;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new Solution1().longestPalindrome("bb"));
    }

    private static class Solution1 {
        /**
         * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
         * 示例 1：
         * 输入: "babad"
         * 输出: "bab"
         * 注意: "aba" 也是一个有效答案。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：184 ms, 在所有 Java 提交中击败了 35.41% 的用户
         * 内存消耗：42.3 MB, 在所有 Java 提交中击败了 36.69% 的用户
         */
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            int len = s.length();
            int maxStart = 0;   //最长回文串的起点
            int maxEnd = 0;     //最长回文串的终点
            int maxLen = 1;     //最长回文串的长度

            boolean[][] dp = new boolean[len][len];
            for (int r = 1; r < len; ++r) {
                for (int l = 0; l < r; ++l) {
                    if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                        dp[l][r] = true;
                        // 保存最优值
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
}
