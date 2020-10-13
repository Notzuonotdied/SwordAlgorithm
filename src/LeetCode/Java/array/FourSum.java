package LeetCode.Java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
         * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
         *
         * 注意：
         *
         * 答案中不可以包含重复的四元组。
         *
         * 示例：
         *
         * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
         *
         * 满足要求的四元组集合为：
         * [
         *   [-1,  0, 0, 1],
         *   [-2, -1, 1, 2],
         *   [-2,  0, 0, 2]
         * ]
         *
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/4sum
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：3 ms, 在所有 Java 提交中击败了99.97% 的用户
         * 内存消耗：39 MB, 在所有 Java 提交中击败了83.00% 的用户
         */
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> quadruplets = new ArrayList<>();
            // 边界检查
            if (nums == null || nums.length < 4) {
                return quadruplets;
            }

            // 先排序，方便处理代码
            Arrays.sort(nums);

            int length = nums.length;
            for (int i = 0; i < length - 3; ++i) {
                // 相同的元素跳过
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 前几个都大于target，不需要比较了
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                // 和后三个元素相加，小于target，可以继续试试
                if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                for (int j = i + 1; j < length - 2; ++j) {
                    // 相同的元素跳过
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    // 前几个都大于target，不需要比较了
                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    // 确定第一个元素，和后两个元素相加，小于target，可以继续试试
                    if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                        continue;
                    }
                    // 查找最后符合的两个元素
                    int left = j + 1;
                    int right = length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            // 保存结果
                            quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            // 找到下一个不一样的元素
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            left++;
                            // 找到下一个不一样的元素
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            right--;
                        } else if (sum < target) {
                            // 找到下一个不一样的元素
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            left++;
                        } else {
                            // 找到下一个不一样的元素
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            right--;
                        }
                    }
                }
            }
            return quadruplets;
        }
    }
}
