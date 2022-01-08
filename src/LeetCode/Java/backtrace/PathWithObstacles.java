package LeetCode.Java.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathWithObstacles {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。
         * 设计一种算法，寻找机器人从左上角移动到右下角的路径。
         *
         * 网格中的障碍物和空位置分别用 1 和 0 来表示。
         *
         * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
         *
         * 示例 1:
         *
         * 输入:
         * [
         *   [0,0,0],
         *   [0,1,0],
         *   [0,0,0]
         * ]
         * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
         * 解释:
         * 输入中标粗的位置即为输出表示的路径，即
         * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/robot-in-a-grid-lcci
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：39.3 MB, 在所有 Java 提交中击败了91.48% 的用户
         */
        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
            int w = obstacleGrid.length;
            int h = obstacleGrid[0].length;
            List<List<Integer>> ans = new ArrayList<>();
            if (obstacleGrid[w - 1][h - 1] == 1) {
                return ans;
            }
            boolean[][] visited = new boolean[w][h];
            backtrace(obstacleGrid, ans, visited, 0, 0);
            return ans;
        }

        /**
         * 回溯算法
         *
         * @param obstacleGrid 网格，1：有障碍；0：无障碍
         * @param ans          最终结果
         * @param visited      访问状态
         * @param i            i
         * @param j            j
         */
        private boolean backtrace(int[][] obstacleGrid, List<List<Integer>> ans, boolean[][] visited, int i, int j) {
            if (i >= obstacleGrid.length || j >= obstacleGrid[0].length) {
                return false;
            }
            if (obstacleGrid[i][j] == 1 || visited[i][j]) {
                return false;
            }
            ans.add(Arrays.asList(i, j));
            visited[i][j] = true;
            if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
                return true;
            }
            if (backtrace(obstacleGrid, ans, visited, i, j + 1) || backtrace(obstacleGrid, ans, visited, i + 1, j)) {
                return true;
            }
            ans.remove(ans.size() - 1);
            return false;
        }
    }
}
