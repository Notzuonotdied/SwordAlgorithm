package LeetCode.Java.dp;

public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(Solution1.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
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
}
