package LeetCode.Java.backtrace;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arrays = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(Solution1.combinationSum2(arrays, 8));
    }

    private static class Solution1 {
        /**
         * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
         *
         * candidates 中的每个数字在每个组合中只能使用一次。
         *
         * 说明：
         *
         *     所有数字（包括目标数）都是正整数。
         *     解集不能包含重复的组合。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/combination-sum-ii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：2 ms, 在所有 Java 提交中击败了99.97% 的用户
         * 内存消耗：38.4 MB, 在所有 Java 提交中击败了99.02% 的用户
         */
        public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            if (candidates.length == 0) {
                return ans;
            }
            // 必须要先排序，不然后续没办法通过判断临近两个数是否是重复的
            Arrays.sort(candidates);
            backtrace(candidates, target, ans, new ArrayList<>(), 0);
            return ans;
        }

        /**
         * 回溯算法
         *
         * @param candidates 候选数字
         * @param target     目标结果
         * @param ans        最终结果
         * @param combine    单次组合结果
         * @param begin      遍历的开始
         */
        private static void backtrace(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int begin) {
            if (target == 0) {
                ans.add(new ArrayList<>(combine));
                return;
            }
            for (int i = begin; i < candidates.length; ++i) {
                // 剪枝，由于已排序，可以通过该方式，去除后续不符合的节点
                if (target - candidates[begin] < 0) {
                    break;
                }
                // 剪枝，去除重复的元素
                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                combine.add(candidates[i]);
                backtrace(candidates, target - candidates[i], ans, combine, i + 1);
                combine.remove(combine.size() - 1);
            }
        }
    }
}
