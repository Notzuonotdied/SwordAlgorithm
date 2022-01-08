package LeetCode.Java.dp;

public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(new Solution1().numDecodings("12") == 2);
        System.out.println(new Solution1().numDecodings("226") == 3);
        System.out.println(new Solution1().numDecodings("0") == 0);
        System.out.println(new Solution1().numDecodings("1") == 1);
        System.out.println(new Solution1().numDecodings("10") == 1);
    }

    private static class Solution1 {
        /**
         * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
         *
         * 'A' -> 1
         * 'B' -> 2
         * ...
         * 'Z' -> 26
         *
         * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
         *
         * 题目数据保证答案肯定是一个 32 位的整数。
         *
         * 示例 1：
         *
         * 输入：s = "12"
         * 输出：2
         * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/decode-ways
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.96% 的用户
         * 内存消耗：36.7 MB, 在所有 Java 提交中击败了77.51% 的用户
         */
        public int numDecodings(String s) {
            int len = s.length();
            int[] dp = new int[len + 1];
            // 默认有一个，解决10这种情况下：dp[i] = dp[i + 2] -> dp[0] = dp[2] = 1
            dp[len] = 1;
            dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
            for (int i = len - 2; i >= 0; --i) {
                // 区间：[10, 26]
                if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                    // 处理：10、20
                    if (s.charAt(i + 1) == '0') {
                        dp[i] = dp[i + 2];
                    }
                    // 处理区间：[11, 19] [21, 26]
                    else {
                        dp[i] = dp[i + 1] + dp[i + 2];
                    }
                }
                // 无法和i + 1组成两个数，单个数也没有意义，直接返回0
                else if (s.charAt(i) == '0') {
                    dp[i] = 0;
                }
                // 处理区间：[3, 9]，无法和i + 1组成两个数
                else {
                    dp[i] = dp[i + 1];
                }
            }
            return dp[0];
        }
    }
}
