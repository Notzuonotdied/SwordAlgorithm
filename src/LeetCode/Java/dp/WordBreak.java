package LeetCode.Java.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
         *
         * 说明：
         *
         *     拆分时可以重复使用字典中的单词。
         *     你可以假设字典中没有重复的单词。
         *
         * 示例 1：
         *
         * 输入: s = "leetcode", wordDict = ["leet", "code"]
         * 输出: true
         * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
         *
         * 执行用时：9 ms, 在所有 Java 提交中击败了58.72% 的用户
         * 内存消耗：38.8 MB, 在所有 Java 提交中击败了51.30% 的用户
         */
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
