package LeetCode.Java.greedy;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(Solution1.maxSubArray(new int[]{-2, 1}));
    }

    private static class Solution1 {
        /**
         * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
         * <p>
         * 示例:
         * <p>
         * 输入: [-2,1,-3,4,-1,2,1,-5,4],
         * 输出: 6
         * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/maximum-subarray
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
