package LeetCode.Java.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    public static void main(String[] args) {
        System.out.println(new Solution1().subsetsWithDup(new int[]{1, 2, 3}));
    }

    private static class Solution1 {
        /**
         * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
         *
         * 说明：解集不能包含重复的子集。
         *
         * 示例:
         *
         * 输入: [1,2,2]
         * 输出:
         * [
         *   [2],
         *   [1],
         *   [1,2,2],
         *   [2,2],
         *   [1,2],
         *   []
         * ]
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/subsets-ii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.96% 的用户
         * 内存消耗：38.8 MB, 在所有 Java 提交中击败了83.00% 的用户
         *
         * 非常推荐阅读以下题解：
         * 子集 II:【彻底理解子集问题如何去重】详解
         * https://leetcode-cn.com/problems/subsets-ii/solution/90-zi-ji-iiche-di-li-jie-zi-ji-wen-ti-ru-he-qu-zho/
         */
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> combine = new ArrayList<>();
            Arrays.sort(nums);
            backtrace(nums, ans, combine, 0);
            return ans;
        }

        private void backtrace(int[] nums, List<List<Integer>> ans, List<Integer> combine, int begin) {
            ans.add(new ArrayList<>(combine));
            for (int i = begin; i < nums.length; ++i) {
                if (i > begin && nums[i] == nums[i - 1]) {
                    continue;
                }
                combine.add(nums[i]);
                backtrace(nums, ans, combine, i + 1);
                combine.remove(combine.size() - 1);
            }
        }
    }
}
