package LeetCode.Java.dp;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(Solution1.uniquePaths(3, 3));
    }

    private static class Solution1 {
        /**
         * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
         *
         * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
         *
         * 问总共有多少条不同的路径？
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/unique-paths
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：34.7 MB, 在所有 Java 提交中击败了99.63% 的用户
         */
        public static int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    dp[j] += dp[j - 1];
                }
            }
            return dp[n - 1];
        }
    }
}
