package LeetCode.Java;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(Solution1.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    private static class Solution1 {
        /**
         * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
         * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
         * 示例 1:
         * 输入: [2,2,1]
         * 输出: 1
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/single-number
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：38 MB, 在所有 Java 提交中击败了97.96% 的用户
         */
        public static int singleNumber(int[] nums) {
            int result = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                result = result ^ nums[i];
            }
            return result;
        }
    }
}
