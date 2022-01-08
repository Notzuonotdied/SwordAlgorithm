package LeetCode.Java.dp;

import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution1().minPathSum(grid));
    }

    private static class Solution1 {
        /**
         * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
         *
         * 说明：每次只能向下或者向右移动一步。
         *
         * 示例 1：
         *
         * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
         * 输出：7
         * 解释：因为路径 1→3→1→1→1 的总和最小。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/minimum-path-sum
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：2 ms, 在所有 Java 提交中击败了97.95% 的用户
         * 内存消耗：41.2 MB, 在所有 Java 提交中击败了80.35% 的用户
         */
        public int minPathSum(int[][] grid) {
            int width = grid[0].length;
            int[] dp = new int[width];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int[] row : grid) {
                dp[0] += row[0];
                for (int i = 1; i < width; ++i) {
                    dp[i] = Math.min(dp[i], dp[i - 1]) + row[i];
                }
            }
            return dp[width - 1];
        }
    }
}
