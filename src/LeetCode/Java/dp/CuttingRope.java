package LeetCode.Java.dp;

import java.math.BigInteger;

public class CuttingRope {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。
         * 请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
         * <p>
         * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * <p>
         * 说明：
         * <p>
         * 当你完全不知道如何处理的时候，建议直接上DP，知道规律就可以处理了。
         * 当你可以用数学归纳法找出规律的时候，知道局部最优的情况，直接用贪心算法即可。
         *
         * @see LeetCode.Java.greedy.CuttingRope
         * <p>
         * 题解：
         * <p>
         * dp[i]表示长度为i的绳子剪完后各段乘积的最大值, 最终目标是dp[n]
         * dp[i]可以看成是长度为i-k的绳子的最大值和长度为k的绳子的最大值的乘积, 子问题最优, 所以dp[i]也是最优
         * 状态转移方程: dp[i] = max(dp[i], dp[i-k] * dp[k])
         */
        public int cuttingRope(int n) {
            if (n <= 3) {
                return n - 1;
            }

            // 下面的初始值不同于上面的特殊情况, 上面是必须剪一刀, 下面的三个初始值不用再减了
            BigInteger[] dp = new BigInteger[n + 1];
            // 初始参数
            dp[1] = new BigInteger("1");
            dp[2] = new BigInteger("2");
            dp[3] = new BigInteger("3");
            for (int i = 4; i <= n; i++) {
                // 初始化dp[i]
                dp[i] = new BigInteger("0");
                // 长度为i的绳子有i-1个剪切位置; 不论i是奇数还是偶数, 只考虑前i/2个剪切位置即可, 后面的剪切位置是重复的
                for (int j = 1; j <= i / 2; j++) {
                    // 因为j和i-j都小于i, 所以这是自底向上的计算方式
                    dp[i] = dp[i].max(dp[j].multiply(dp[i - j]));
                }
            }
            return dp[n].mod(new BigInteger("1000000007")).intValue();
        }
    }
}
