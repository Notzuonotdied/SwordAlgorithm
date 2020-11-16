package LeetCode.Java.greedy;

public class CanJump {
    public static void main(String[] args) {
        System.out.println(new Solution1().canJump(new int[]{2, 3, 1, 1, 4}));
    }

    private static class Solution1 {
        /**
         * 给定一个非负整数数组，你最初位于数组的第一个位置。
         * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
         * 判断你是否能够到达最后一个位置。
         *
         * 示例 1:
         *
         * 输入: [2,3,1,1,4]
         * 输出: true
         * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/jump-game
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：2 ms, 在所有 Java 提交中击败了81.37% 的用户
         * 内存消耗：40.4 MB, 在所有 Java 提交中击败了81.48% 的用户
         */
        public boolean canJump(int[] nums) {
            int length = nums.length;
            int rightMost = 0;
            for (int i = 0; i < length; ++i) {
                if (i <= rightMost) {
                    rightMost = Math.max(rightMost, i + nums[i]);
                    if (rightMost >= length - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
