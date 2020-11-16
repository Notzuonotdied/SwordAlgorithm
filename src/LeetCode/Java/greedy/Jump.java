package LeetCode.Java.greedy;

public class Jump {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个非负整数数组，你最初位于数组的第一个位置。
         * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
         * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
         *
         * 示例:
         *
         * 输入: [2,3,1,1,4]
         * 输出: 2
         * 解释: 跳到最后一个位置的最小跳跃数是 2。
         *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
         *
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/jump-game-ii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：2 ms, 在所有 Java 提交中击败了93.98% 的用户
         * 内存消耗：40.5 MB, 在所有 Java 提交中击败了76.04% 的用户
         */
        public int jump(int[] nums) {
            int length = nums.length;
            int rightMost = 0;
            int step = 0;
            int end = 0;
            // 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，
            // 我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
            for (int i = 0; i < length - 1; ++i) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (i == end) {
                    end = rightMost;
                    ++step;
                }
            }
            return step;
        }
    }
}
