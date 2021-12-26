package LeetCode.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        test(new Solution1(), new int[]{-1, 0, 1, 2, -1, -4});
    }

    private static void test(ISolution solution, int[] arr) {
        System.out.println(solution.threeSum(arr));
    }

    private interface ISolution {
        List<List<Integer>> threeSum(int[] nums);
    }

    private static class Solution1 implements ISolution {
        /**
         * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
         * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
         * 注意：答案中不可以包含重复的三元组。
         * 示例 1：
         * 输入：nums = [-1,0,1,2,-1,-4]
         * 输出：[[-1,-1,2],[-1,0,1]]
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/3sum
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 视频题解：先排序，后去重
         * https://leetcode-cn.com/problems/3sum/solution/javashi-pin-jiang-jie-xi-lie-3-sum-by-sean-kuang/
         * 博文题解：
         * 1. https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/441056
         * 2. https://blog.csdn.net/starflyyy/article/details/106955473
         * <p>
         * 执行用时：19 ms, 在所有 Java 提交中击败了95.03% 的用户
         * 内存消耗：42.1 MB, 在所有 Java 提交中击败了78.43% 的用户
         */
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length <= 2) {
                return ans;
            }
            // 先排序，方便后续去重（剪枝）
            Arrays.sort(nums); // O(nlogn)
            int target, start, end;
            for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
                // 排序后的数组，大于0的情况都可以直接排除
                if (nums[i] > 0) {
                    break;
                }
                // 去重
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                target = -nums[i];
                start = i + 1;
                end = nums.length - 1;
                while (start < end) {
                    if (nums[start] + nums[end] == target) {
                        // 保存结果后，需要将索引向内靠拢，准备去重
                        ans.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                        // 去重剪枝
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (nums[start] + nums[end] < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
            return ans;
        }
    }
}
