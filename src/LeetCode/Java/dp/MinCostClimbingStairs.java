package LeetCode.Java.dp;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(Solution1.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));// 6
        System.out.println(Solution1.minCostClimbingStairs(new int[]{10, 15, 20}));// 15
        System.out.println(Solution1.minCostClimbingStairs(new int[]{0, 0, 0, 2}));// 2
    }

    private static class Solution1 {
        /**
         * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
         * <p>
         * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
         * <p>
         * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * <p>
         * 执行用时 :1 ms, 在所有 Java 提交中击败了99.88% 的用户
         * 内存消耗 :39.5 MB, 在所有 Java 提交中击败了11.11%的用户
         */
        public static int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[3];
            for (int i = 2; i <= cost.length; i++) {
                dp[2] = Math.min(dp[0] + cost[i - 2], dp[1] + cost[i - 1]);
                dp[0] = dp[1];
                dp[1] = dp[2];
            }
            return dp[2];
        }
    }
}
