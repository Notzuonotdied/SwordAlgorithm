package LeetCode.Java.dp;

public class CountDigitOne {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
         * <p>
         * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
         * <p>
         * 示例 1：
         * <p>
         * 输入：n = 12
         * 输出：5
         * <p>
         * 示例 2：
         * <p>
         * 输入：n = 13
         * 输出：6
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗 :36.6 MB, 在所有 Java 提交中击败了100.00%的用户
         * <p>
         * 具体题解详见：
         *
         * @see LeetCode.Java.dp.NumberOf2sInRange 同款可以用数位DP解决的题目
         */
        public int countDigitOne(int n) {
            if (n == 0) {
                return 0;
            }

            int digit = (int) Math.log10(n) + 1;
            int[][] dp = new int[digit + 1][2];
            // dp[i][0]:保存0~n的1-i位组成的数包含2的个数
            // dp[i][1]:保存i位均为9包含2的个数，用于后面状态的更新
            dp[1][0] = n % 10 >= 1 ? 1 : 0;
            dp[1][1] = 1;
            for (int i = 2; i <= digit; ++i) {
                int curBase = (int) Math.pow(10, i - 1);
                // 取出指定位的值
                int k = n / curBase % 10;
                dp[i][0] = k * dp[i - 1][1] + dp[i - 1][0];
                if (k == 1) {
                    dp[i][0] += n % curBase + 1;
                } else if (k > 1) {
                    dp[i][0] += curBase;
                }
                dp[i][1] = 10 * dp[i - 1][1] + curBase;
            }
            return dp[digit][0];
        }
    }
}
