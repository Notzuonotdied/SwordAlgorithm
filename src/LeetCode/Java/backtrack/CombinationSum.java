package LeetCode.Java.backtrack;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5};
        System.out.println(Solution1.combinationSum(array, 8));
    }

    private static class Solution1 {

        /**
         * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
         *
         * candidates 中的数字可以无限制重复被选取。
         *
         * 说明：
         *
         *     所有数字（包括 target）都是正整数。
         *     解集不能包含重复的组合。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/combination-sum
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 题解：通过每次递归分为移动下标和不动下标来实现全盘可重复元素搜索。
         * 链接：https://leetcode-cn.com/problems/combination-sum/solution/zu-he-zong-he-by-leetcode-solution/
         */
        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> combine = new ArrayList<>();
            backtrace(candidates, target, result, combine, 0);
            return result;
        }

        /**
         * 执行用时：2 ms, 在所有 Java 提交中击败了99.92% 的用户
         * 内存消耗：38.7 MB, 在所有 Java 提交中击败了92.81% 的用户
         *
         * .
         * ├── 2
         * │   ├── 2
         * │   │   ├── 2
         * │   │   │   ├── 2
         * │   │   │   ├── 3
         * │   │   │   └── 5
         * │   │   ├── 3
         * │   │   │   ├── 3
         * │   │   │   └── 5
         * │   │   └── 5
         * │   ├── 3
         * │   │   ├── 3
         * │   │   └── 5
         * │   └── 5
         * │       └── 5
         * ├── 3
         * │   ├── 3
         * │   │   ├── 3
         * │   │   └── 5
         * │   └── 5
         * └── 5
         *     └── 5
         */
        public static void backtrace(int[] candidates, int target, List<List<Integer>> result,
                                     List<Integer> combine, int depth) {
            if (depth == candidates.length) {
                return;
            }

            if (target == 0) {
                result.add(new ArrayList<>(combine));
                return;
            }

            // 通过每次递归分为移动下标和不动下标来实现全盘可重复元素搜索
            // 使用移动下标来剪枝，不处理下标小于当前下标的元素，即如果当前下标为3，仅仅处理[3, length)区间的数据
            backtrace(candidates, target, result, combine, depth + 1);
            if (target - candidates[depth] >= 0) {
                combine.add(candidates[depth]);
                backtrace(candidates, target - candidates[depth], result, combine, depth);
                combine.remove(combine.size() - 1);
            }
        }
    }

    public static class Solution2 {

        /**
         * 标准回溯思路
         *
         * 执行用时：5 ms, 在所有 Java 提交中击败了39.30% 的用户
         * 内存消耗：38.7 MB, 在所有 Java 提交中击败了93.10% 的用户
         */
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (candidates.length == 0) {
                return res;
            }
            Deque<Integer> path = new ArrayDeque<>();
            backtrack(candidates, target, path, res, 0);
            return res;
        }

        /**
         * @param candidates 候选数组
         * @param target     每减去一个元素，目标值变小
         * @param combine    从根结点到叶子结点的路径，是一个栈
         * @param res        结果集列表
         * @param depth      搜索深度
         */
        private void backtrack(int[] candidates, int target, Deque<Integer> combine, List<List<Integer>> res, int depth) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                res.add(new ArrayList<>(combine));
                return;
            }
            for (int i = depth; i < candidates.length; i++) {
                combine.addLast(candidates[i]);
                backtrack(candidates, target - candidates[i], combine, res, i);
                combine.removeLast();
            }
        }
    }
}
