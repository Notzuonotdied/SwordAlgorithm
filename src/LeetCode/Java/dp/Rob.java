package LeetCode.Java.dp;

public class Rob {
    public static void main(String[] args) {
        System.out.println(Solution1.rob(new int[]{2, 7, 9, 3, 1}));
    }

    private static class Solution1 {
        /**
         * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
         * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
         * <p>
         * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/house-robber
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗 :37 MB, 在所有 Java 提交中击败了6.52%的用户
         *
         * @see Massage 同款打家劫舍问题。
         */
        public static int rob(int[] nums) {
            int[] dp = new int[3];
            for (int i = 0; i < nums.length; i++) {
                dp[(i + 2) % 3] = Math.max(dp[i % 3] + nums[i], dp[(i + 1) % 3]);
            }
            return dp[(nums.length + 1) % 3];
        }
    }
}
