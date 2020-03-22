package LeetCode.Java;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        int result = Solution1.lengthOfLongestSubstring(" ");
        System.out.println(result);
    }

    private static class Solution1 {

        /**
         * 使用dp解决最大连续不重复子串
         */
        public static int lengthOfLongestSubstring(String s) {
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
}
