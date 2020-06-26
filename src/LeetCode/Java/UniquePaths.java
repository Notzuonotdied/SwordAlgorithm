package LeetCode.Java;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(Solution1.uniquePaths(3, 1));
    }

    private static class Solution1 {
        /**
         * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
         * <p>
         * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
         * <p>
         * 问总共有多少条不同的路径？
         * <p>
         * 动态规划方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/unique-paths
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        public static int uniquePaths(int m, int n) {
            int[] cur = new int[n];
            Arrays.fill(cur, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    cur[j] += cur[j - 1];
                }
            }
            return cur[n - 1];
        }
    }
}
