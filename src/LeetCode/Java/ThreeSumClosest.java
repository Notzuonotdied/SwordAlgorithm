package LeetCode.Java;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(Solution1.threeSumClosest(new int[]{1, 1, 1, 0}, 100));
    }

    private static class Solution1 {
        /**
         * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
         * 返回这三个数的和。假定每组输入只存在唯一答案。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/3sum-closest
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        public static int threeSumClosest(int[] nums, int target) {
            if (nums.length == 0) {
                return target;
            }
            Arrays.sort(nums);
            // 这么写可以解决频繁申请内存的问题
            // 执行用时 :5 ms, 在所有 Java 提交中击败了96.09% 的用户
            int sum, left, right, curDst;
            int ans = target;
            int dst = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; ++i) {
                left = i + 1;
                right = nums.length - 1;

                while (left < right) {
                    sum = nums[left] + nums[right] + nums[i];
                    curDst = sum - target;
                    if (curDst == 0) {
                        return sum;
                    } else if (curDst > 0) {
                        right--;
                    } else {
                        left++;
                    }

                    if (Math.abs(curDst) < dst) {
                        ans = sum;
                        dst = Math.abs(curDst);
                    }
                }
            }
            return ans;
        }
    }
}
