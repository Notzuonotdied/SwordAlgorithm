package LeetCode.Java.dp;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(Solution1.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(Solution1.maxSubArray(new int[]{1}));
        System.out.println(Solution1.maxSubArray(new int[]{-2, 1}));
    }

    private static class Solution1 {
        /**
         * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
         * <p>
         * 要求时间复杂度为O(n)。
         * <p>
         * 示例1:
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        public static int maxSubArray(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int count = nums[0];
            int maxCount = count;
            for (int i = 1; i < nums.length; ++i) {
                if (count > 0) {
                    count += nums[i];
                } else {
                    count = nums[i];
                }
                if (count > maxCount) {
                    maxCount = count;
                }
            }
            return maxCount;
        }
    }
}
