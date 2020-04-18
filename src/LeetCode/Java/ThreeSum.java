package LeetCode.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(Solution1.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    private static class Solution1 {
        /**
         * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
         * <p>
         * 注意：答案中不可以包含重复的三元组。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/3sum
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 题解：先排序，后去重
         * <p>
         * https://leetcode-cn.com/problems/3sum/solution/javashi-pin-jiang-jie-xi-lie-3-sum-by-sean-kuang/
         */
        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length == 0) {
                return result;
            }
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; ++i) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int target = -nums[i];
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[j] + nums[k] == target) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[k]);
                        result.add(curr);

                        j++;
                        k--;
                        while (j < nums.length && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while (k > j && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    } else if (nums[j] + nums[k] > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }

            return result;
        }
    }
}
