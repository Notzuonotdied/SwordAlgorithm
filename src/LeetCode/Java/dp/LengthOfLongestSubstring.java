package LeetCode.Java.dp;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        int result1 = new Solution1().lengthOfLongestSubstring("");
        int result2 = new Solution2().lengthOfLongestSubstring("");
        System.out.println(result1);
        System.out.println(result2);
    }

    private interface ISolution {
        int lengthOfLongestSubstring(String s);
    }

    private static class Solution1 implements ISolution {

        /**
         * 使用类似DP的方案解决下述问题。
         * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
         * 示例 1:
         * 输入: "abcabcbb"
         * 输出: 3
         * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        public int lengthOfLongestSubstring(String s) {
            // 开始的指针位置
            int start = 0;
            int[] dp = new int[s.length() + 1];
            for (int end = 0; end < s.length(); end++) {
                // 判断子串中是否有相同的字符
                int index = s.substring(start, end).indexOf(s.charAt(end));
                if (index != -1) {
                    // 存在则调整起始指针
                    start = start + index + 1;
                }
                dp[end + 1] = Math.max(dp[end], end - start + 1);
            }
            return dp[s.length()];
        }
    }

    private static class Solution2 implements ISolution {

        /**
         * 执行用时：3 ms, 在所有 Java 提交中击败了88.68% 的用户
         * 内存消耗：38.7 MB, 在所有 Java 提交中击败了23.31% 的用户
         */
        public int lengthOfLongestSubstring(String s) {
            int maxLength = 0;

            for (int start = 0, end = 0; end < s.length(); ++end) {
                int index = s.substring(start, end).lastIndexOf(s.charAt(end));
                if (index != -1) {
                    start += index + 1;
                }
                maxLength = Math.max(maxLength, end - start + 1);
            }
            return maxLength;
        }
    }
}
