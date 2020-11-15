package LeetCode.Java.backtrack;

import java.util.*;

public class Partition {
    public static void main(String[] args) {
        System.out.println(new Solution1().partition("aab"));
    }

    private static class Solution1 {
        /**
         * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
         *
         * 返回 s 所有可能的分割方案。
         *
         * 示例:
         *
         * 输入: "aab"
         * 输出:
         * [
         *   ["aa","b"],
         *   ["a","a","b"]
         * ]
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：2 ms, 在所有 Java 提交中击败了98.27% 的用户
         * 内存消耗：39.5 MB, 在所有 Java 提交中击败了77.05% 的用户
         */
        public List<List<String>> partition(String s) {
            int length = s.length();
            List<List<String>> ans = new ArrayList<>();
            if (length == 0) {
                return ans;
            }
            Deque<String> combine = new ArrayDeque<>();
            // 使用动态规划，先计算出回文字符串
            boolean[][] dp = new boolean[length][length];
            for (int right = 0; right < length; ++right) {
                for (int left = 0; left <= right; ++left) {
                    if (s.charAt(left) != s.charAt(right)) {
                        continue;
                    }
                    if (right - left <= 2 || dp[left + 1][right - 1]) {
                        dp[left][right] = true;
                    }
                }
            }

            backtrace(s, ans, combine, dp, 0, length);
            return ans;
        }

        private void backtrace(String s, List<List<String>> ans, Deque<String> combine, boolean[][] dp, int start, int length) {
            if (start == length) {
                ans.add(new ArrayList<>(combine));
                return;
            }
            for (int i = start; i < length; ++i) {
                // 因为dp的范围是[start, i]
                if (!dp[start][i]) {
                    continue;
                }
                // subString的截取范围为[start, nextStart)
                int nextStart = i + 1;
                combine.push(s.substring(start, nextStart));
                backtrace(s, ans, combine, dp, nextStart, length);
                combine.removeLast();
            }
        }
    }
}
