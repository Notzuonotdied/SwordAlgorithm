package LeetCode.Java.backtrace;

public class NumIslands {

    public static void main(String[] args) {

    }

    private interface ISolution {
        int numIslands(char[][] grid);
    }

    private static class Solution1 implements ISolution {

        /**
         * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
         * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
         * 此外，你可以假设该网格的四条边均被水包围。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/number-of-islands
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 不恢复数据：
         * 执行用时：2 ms, 在所有 Java 提交中击败了99.79% 的用户
         * 内存消耗：46.8 MB, 在所有 Java 提交中击败了20.10% 的用户
         * 恢复数据：
         * 执行用时：4 ms, 在所有 Java 提交中击败了40.23% 的用户
         * 内存消耗：46.8 MB, 在所有 Java 提交中击败了23.25% 的用户
         */
        public int numIslands(char[][] grid) {
            if (grid == null) {
                return 0;
            }
            int w = grid.length;
            int h = grid[0].length;
            int ans = 0;
            for (int i = 0; i < w; ++i) {
                for (int j = 0; j < h; ++j) {
                    if (grid[i][j] == '1') {
                        ans++;
                        // 递归，将1周围的数据都标记上
                        dfs(grid, w, h, i, j);
                    }
                }
            }
            revert(grid, w, h);
            return ans;
        }

        private void dfs(char[][] grid, int w, int h, int i, int j) {
            // 边界判断
            if (i < 0 || j < 0 || i >= w || j >= h || grid[i][j] != '1') {
                return;
            }
            // 标记，用于恢复现场
            grid[i][j] = '2';
            dfs(grid, w, h, i + 1, j);
            dfs(grid, w, h, i - 1, j);
            dfs(grid, w, h, i, j + 1);
            dfs(grid, w, h, i, j - 1);
        }

        /**
         * 恢复现场
         */
        private void revert(char[][] grid, int w, int h) {
            for (int i = 0; i < w; ++i) {
                for (int j = 0; j < h; ++j) {
                    if (grid[i][j] == '2') {
                        grid[i][j] = '1';
                    }
                }
            }
        }
    }
}
