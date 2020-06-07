package LeetCode.Java.dp;

public class NumberOf2sInRange {
    public static void main(String[] args) {
        System.out.println(Solution1.numberOf2sInRange(78));
        System.out.println(Solution1.numberOf2sInRange(178));
    }

    private static class Solution1 {
        /**
         * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
         * <p>
         * 示例:
         * <p>
         * 输入: 25
         * 输出: 9
         * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/number-of-2s-in-range-lcci
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * dp[i]与dp[i-1]的关系，假设n的第i位的值为k：
         * dp[i] = k * numberOf2sInRange(99..9){共i-1个9} + dp[i-1] + {n % 10^(i-1) + 1 }{若k == 2} + {10^(i-1)} {若k > 2}
         * <p>
         * <p>
         * 作者：sagacioushugo
         * 链接：https://leetcode-cn.com/problems/number-of-2s-in-range-lcci/solution/javajie-fa-shu-wei-dp-shuang-100-by-sagacioushugo/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @see LeetCode.Java.dp.CountDigitOne 同款可以用数位DP解决的题目
         */
        public static int numberOf2sInRange(int n) {
            if (n == 0) {
                return 0;
            }
            int digit = (int) Math.log10(n) + 1;
            int[][] dp = new int[digit + 1][2];
            // dp[i][0] = numberOf2sInRange(n % pow(10, i)) 保存[0, n]的[1, i]位组成的数包含2的个数
            // dp[i][1] = numberOf2sInRange(99..9) 保存i位均为9包含2的个数
            dp[1][0] = n % 10 >= 2 ? 1 : 0;
            dp[1][1] = 1;
            for (int i = 2; i <= digit; i++) {
                int curBase = (int) Math.pow(10, i - 1);
                // 取出指定位的值
                int k = n / curBase % 10;
                dp[i][0] = k * dp[i - 1][1] + dp[i - 1][0];
                if (k == 2) {
                    dp[i][0] += n % curBase + 1;
                } else if (k > 2) {
                    dp[i][0] += curBase;
                }
                dp[i][1] = 10 * dp[i - 1][1] + curBase;
            }
            return dp[digit][0];
        }
    }
}
