package LeetCode.Java.dp;

public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(Solution1.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(Solution2.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    private static class Solution1 {
        /**
         * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
         * <p>
         * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
         * <p>
         * 注意：你不能在买入股票前卖出股票。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 动态规划的入门题，根据前面状态更新。请看如下题解：
         * <p>
         * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/gu-piao-wen-ti-python3-c-by-z1m/
         */
        public static int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int profile = 0;
            int minPrice = prices[0];
            for (int price : prices) {
                profile = Math.max(profile, price - minPrice);
                minPrice = Math.min(minPrice, price);
            }

            return profile;
        }
    }


    public static class Solution2 {
        /**
         * 时间：2020年06月06日22:00:56
         * <p>
         * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
         * <p>
         * 这个问题其实包含了一个重复子问题，就是每次都需要找局部最优解。
         * <p>
         * 执行用时 :2 ms, 在所有 Java 提交中击败了66.01% 的用户
         * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了100.00%的用户
         */
        public static int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int[] dp = new int[1];
            int minProfile = prices[0];
            for (int i = 1; i < prices.length; ++i) {
                dp[0] = Math.max(dp[0], prices[i] - minProfile);
                // 利润最低点
                minProfile = Math.min(minProfile, prices[i]);
            }

            return dp[0];
        }
    }


}
