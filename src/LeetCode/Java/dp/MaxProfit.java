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
         * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
         * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
         * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
         * 示例 1：
         * 输入：[7,1,5,3,6,4]
         * 输出：5
         * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
         * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：2 ms, 在所有 Java 提交中击败了91.65% 的用户
         * 内存消耗：50.8 MB, 在所有 Java 提交中击败了95.54% 的用户
         */
        public static int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int ans = 0;
            int minProfile = prices[0];
            for (int i = 1; i < prices.length; ++i) {
                // 收益最大化
                ans = Math.max(ans, prices[i] - minProfile);
                // 历史最低点
                minProfile = Math.min(minProfile, prices[i]);
            }

            return ans;
        }
    }


}
