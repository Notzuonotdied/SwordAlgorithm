package LeetCode.Java.dp;

public class Rob2 {
    public static void main(String[] args) {
        System.out.println(new Solution1().rob(new int[]{1, 2}) == 2);
        System.out.println(new Solution1().rob(new int[]{2, 3, 2}) == 3);
        System.out.println(new Solution1().rob(new int[]{1, 2, 3, 1}) == 4);
        System.out.println(new Solution1().rob(new int[]{2, 3, 2, 5, 8}) == 11);
    }

    private static class Solution1 {
        /**
         * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
         * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
         * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
         *
         * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
         *
         * 示例 1：
         *
         * 输入：nums = [2,3,2]
         * 输出：3
         * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/house-robber-ii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：35.7 MB, 在所有 Java 提交中击败了87.30% 的用户
         */
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            } else if (len == 1) {
                return nums[0];
            }
            int pre1 = 0, cur1 = 0, tmp1;
            int pre2 = 0, cur2 = 0, tmp2;
            for (int i = 0; i < len - 1; ++i) {
                // 第一次判断，从区间[0, len-1)开始
                tmp1 = cur1;
                cur1 = Math.max(pre1 + nums[i], cur1);
                pre1 = tmp1;

                // 第二次判断，从区间[1, len)开始
                tmp2 = cur2;
                cur2 = Math.max(pre2 + nums[i + 1], cur2);
                pre2 = tmp2;
            }
            return Math.max(cur1, cur2);
        }
    }
}
