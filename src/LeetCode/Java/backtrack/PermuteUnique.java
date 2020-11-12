package LeetCode.Java.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
         *
         * 示例 1：
         *
         * 输入：nums = [1,1,2]
         * 输出：
         * [[1,1,2],
         *  [1,2,1],
         *  [2,1,1]]
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/permutations-ii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.99% 的用户
         * 内存消耗：39.3 MB, 在所有 Java 提交中击败了81.56% 的用户
         */
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> combine = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            Arrays.sort(nums);
            backtrace(nums, ans, combine, visited, 0);
            return ans;
        }

        private void backtrace(int[] nums, List<List<Integer>> ans, List<Integer> combine, boolean[] visited, int depth) {
            if (depth == nums.length) {
                ans.add(new ArrayList<>(combine));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {
                if (visited[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                combine.add(nums[i]);
                visited[i] = true;
                backtrace(nums, ans, combine, visited, depth + 1);
                visited[i] = false;
                combine.remove(combine.size() - 1);
            }
        }
    }
}
