package LeetCode.Java.dp;


public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(new Solution1().maxProduct(new int[]{1}) == 1);
        System.out.println(new Solution1().maxProduct(new int[]{0, 2}) == 2);
        System.out.println(new Solution1().maxProduct(new int[]{-2, 0, -1}) == 0);
        System.out.println(new Solution1().maxProduct(new int[]{-2, 3, -4}) == 24);
        System.out.println(new Solution1().maxProduct(new int[]{2, 3, -2, 4}) == 6);
    }

    private static class Solution1 {
        /**
         * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
         *
         * 示例 1:
         *
         * 输入: [2,3,-2,4]
         * 输出: 6
         * 解释: 子数组 [2,3] 有最大乘积 6。
         *
         * 示例 2:
         *
         * 输入: [-2,0,-1]
         * 输出: 0
         * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：2 ms, 在所有 Java 提交中击败了89.01% 的用户
         * 内存消耗：38 MB, 在所有 Java 提交中击败了94.87% 的用户
         */
        public int maxProduct(int[] nums) {
            int mx, mn;
            int max = nums[0], min = nums[0], ans = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                mx = max * nums[i];
                mn = min * nums[i];
                max = Math.max(nums[i], Math.max(mx, mn));
                min = Math.min(nums[i], Math.min(mx, mn));
                ans = Math.max(max, ans);
            }
            return ans;
        }
    }

    private static class Solution2 {
        /**
         * 执行用时：390 ms, 在所有 Java 提交中击败了5.29% 的用户
         * 内存消耗：38.4 MB, 在所有 Java 提交中击败了71.50% 的用户
         */
        public int maxProduct(int[] nums) {
            int maxProfile = Integer.MIN_VALUE;
            int[] dp = new int[2];
            for (int i = 0; i < nums.length; ++i) {
                for (int j = i; j < nums.length; ++j) {
                    dp[1] = j > i ? dp[0] * nums[j] : nums[j];
                    maxProfile = Math.max(maxProfile, dp[1]);
                    dp[0] = dp[1];
                }
            }
            return maxProfile;
        }
    }
}
