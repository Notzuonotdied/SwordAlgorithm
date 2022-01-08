package LeetCode.Java.dp;

public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] arrays = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new Solution1().uniquePathsWithObstacles(arrays));
    }

    private static class Solution1 {
        /**
         * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
         *
         * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
         *
         * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/unique-paths-ii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：36.2 MB, 在所有 Java 提交中击败了98.48% 的用户
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int width = obstacleGrid[0].length;
            int[] dp = new int[width];
            dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
            for (int[] row : obstacleGrid) {
                for (int i = 0; i < width; ++i) {
                    if (row[i] == 1) {
                        dp[i] = 0;
                        continue;
                    }
                    if (i > 1 && row[i - 1] == 0) {
                        dp[i] += dp[i - 1];
                    }
                }
            }
            return dp[width - 1];
        }
    }
}
