package LeetCode.Java.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
         *
         * 示例:
         *
         * 输入: n = 4, k = 2
         * 输出:
         * [
         *   [2,4],
         *   [3,4],
         *   [2,3],
         *   [1,2],
         *   [1,3],
         *   [1,4],
         * ]
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/combinations
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：23 ms, 在所有 Java 提交中击败了44.44% 的用户
         * 内存消耗：39.8 MB, 在所有 Java 提交中击败了90.47% 的用户
         */
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> combine = new ArrayList<>();
            boolean[] visited = new boolean[n];
            backtrace(n, k, ans, combine, visited, 0);
            return ans;
        }

        private void backtrace(int n, int k, List<List<Integer>> ans, List<Integer> combine, boolean[] visited, int depth) {
            if (depth == k) {
                ans.add(new ArrayList<>(combine));
                return;
            }
            for (int i = 0; i < n; ++i) {
                if (visited[i]) {
                    break;
                }
                combine.add(i + 1);
                visited[i] = true;
                backtrace(n, k, ans, combine, visited, depth + 1);
                visited[i] = false;
                combine.remove(combine.size() - 1);
            }
        }
    }

    private static class Solution2 {
        /**
         * 调整了一处细节，提高了效率
         *
         * 执行用时：24 ms, 在所有 Java 提交中击败了39.44% 的用户
         * 内存消耗：39.7 MB, 在所有 Java 提交中击败了95.83% 的用户
         */
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> combine = new ArrayList<>();
            boolean[] visited = new boolean[n];
            backtrace(n, k, ans, combine, visited, 0);
            return ans;
        }

        private void backtrace(int n, int k, List<List<Integer>> ans, List<Integer> combine, boolean[] visited, int depth) {
            if (combine.size() == k) {
                ans.add(new ArrayList<>(combine));
                return;
            }
            // 和上一题的区别在于i的值为depth
            for (int i = depth; i < n; ++i) {
                if (visited[i]) {
                    break;
                }
                combine.add(i + 1);
                visited[i] = true;
                // 和上一题的区别在于depth的值为i + 1
                backtrace(n, k, ans, combine, visited, i + 1);
                visited[i] = false;
                combine.remove(combine.size() - 1);
            }
        }
    }
}
