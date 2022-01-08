package LeetCode.Java.dp;

import LeetCode.Java.common.CMaxSubArray;

public class MaxSubArray extends CMaxSubArray {

    public static void main(String[] args) {
        test(new Solution1());
    }

    private static class Solution1 implements IMaxSubArray {
        /**
         * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
         * <p>
         * 示例 1：
         * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
         * 输出：6
         * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/maximum-subarray
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：1 ms, 在所有 Java 提交中击败了91.20% 的用户
         * 内存消耗：37.8 MB, 在所有 Java 提交中击败了99.22% 的用户
         */
        @Override
        public int maxSubArray(int[] nums) {
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
