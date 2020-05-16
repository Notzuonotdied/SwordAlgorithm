package LeetCode.Java.dp;

public class Massage {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
         * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
         * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
         * <p>
         * 注意：本题相对原题稍作改动
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗 :37 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @see Rob 同款打家劫舍问题。
         */
        public int massage(int[] nums) {
            int[] dp = new int[3];
            for (int i = 0; i < nums.length; ++i) {
                dp[(i + 2) % 3] = Math.max(dp[i % 3] + nums[i], dp[(i + 1) % 3]);
            }
            return dp[(nums.length + 1) % 3];
        }
    }
}
