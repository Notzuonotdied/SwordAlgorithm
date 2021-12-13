package LeetCode.Java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        test(new Solution1(), array);
        test(new Solution2(), array);
    }

    private static void test(ISolution solution, int[] array) {
        System.out.println(solution.findDisappearedNumbers(array));
        System.out.println(Arrays.toString(array));
    }

    private interface ISolution {
        List<Integer> findDisappearedNumbers(int[] nums);
    }

    private static class Solution1 implements ISolution {

        /**
         * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
         * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
         * 示例 1：
         * 输入：nums = [4,3,2,7,8,2,3,1]
         * 输出：[5,6]
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 官方分析：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/zhao-dao-suo-you-shu-zu-zhong-xiao-shi-d-mabl/
         * <p>
         * 执行用时：3 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：46.8 MB, 在所有 Java 提交中击败了90.82% 的用户
         */
        @Override
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            for (int num : nums) {
                int x = (num - 1) % n;
                nums[x] += n;
            }
            List<Integer> ret = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (nums[i] <= n) {
                    ret.add(i + 1);
                }
            }
            return ret;
        }
    }

    /**
     * 数据恢复版本
     */
    private static class Solution2 implements ISolution {

        /**
         * 执行用时：4 ms, 在所有 Java 提交中击败了58.62% 的用户
         * 内存消耗：46.7 MB, 在所有 Java 提交中击败了93.55% 的用户
         */
        @Override
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return ans;
            }
            int len = nums.length, i;
            for (int num : nums) {
                i = (num - 1) % len;
                if (nums[i] <= len) {
                    // 确保仅仅被记录一次，保证数据可以恢复
                    nums[i] += len;
                }
            }
            for (i = 0; i < len; ++i) {
                if (nums[i] <= len) {
                    ans.add(i + 1);
                } else {
                    // 恢复数据
                    nums[i] -= len;
                }
            }
            return ans;
        }
    }
}
