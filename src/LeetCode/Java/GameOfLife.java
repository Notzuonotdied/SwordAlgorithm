package LeetCode.Java;

public class GameOfLife {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
         * <p>
         * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），
         * 或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
         * <p>
         * * * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
         * * * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
         * * * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
         * * * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
         * <p>
         * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态
         * 下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/game-of-life
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 简化逻辑：
         * * * 如果原来是活的，周围有[2,3]个活细胞，存活；
         * * * 如果原来是死的，周围有[3]个活细胞，复活；
         * * * 其他都死了。
         * <p>
         * 进一步合并：
         * * * 如果周围有3个活细胞，存活；
         * * * 如果周围有两个活细胞，且是活细胞，存活；
         * * * 其他都死了。
         */
        public void gameOfLife(int[][] board) {
            int width = board.length;
            int height = board[0].length;

            for (int i = 0; i < width; ++i) {
                for (int j = 0; j < height; ++j) {
                    if (board[i][j] % 10 != 1) {
                        continue;
                    }
                    // 仅仅计算存活细胞
                    affect(board, width, height, new int[]{i - 1, i, i + 1}, new int[]{j - 1, j, j + 1});
                }
            }

            for (int i = 0; i < width; ++i) {
                for (int j = 0; j < height; ++j) {
                    int value = board[i][j];
                    if (value / 10 == 3) {
                        board[i][j] = 1;
                    } else if (value / 10 == 2 && value % 10 == 1) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }

        private void affect(int[][] board, int width, int height, int[] x, int[] y) {
            for (int i = 0; i < x.length; ++i) {
                for (int j = 0; j < y.length; ++j) {
                    if (x[i] < 0 || x[i] >= width || y[j] < 0 || y[j] >= height) {
                        continue;
                    }
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    board[x[i]][y[j]] += 10;
                }
            }
        }
    }
}
