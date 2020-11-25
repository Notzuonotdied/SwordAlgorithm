package LeetCode.Java.dp;

public class WaysToChange {
    public static void main(String[] args) {
    }

    private static class Solution1 {
        /**
         * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
         *
         * 示例1:
         *
         *  输入: n = 5
         *  输出：2
         *  解释: 有两种方式可以凑成总金额:
         * 5=5
         * 5=1+1+1+1+1
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/coin-lcci
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：43 ms, 在所有 Java 提交中击败了73.14% 的用户
         * 内存消耗：42.3 MB, 在所有 Java 提交中击败了82.70% 的用户
         */
        private static final int MOD = 1000000007;
        private static final int[] COINS = {25, 10, 5, 1};

        public int waysToChange(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int coin : COINS) {
                for (int i = coin; i <= n; ++i) {
                    dp[i] = (dp[i] + dp[i - coin]) % MOD;
                }
            }
            return dp[n];
        }
    }
}
