package LeetCode.Java;

import java.util.List;
import java.util.ArrayList;

public class SpiralOrder {
    public static void main(String[] args) {
        System.out.println(Solution1.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    private static class Solution1 {
        /**
         * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
         * <p>
         * 题解：https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode/
         */
        public static List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix.length == 0) {
                return res;
            }
            int R = matrix.length, C = matrix[0].length;
            boolean[][] seen = new boolean[R][C];
            // 判断当前方向的计算方式
            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};
            // di是前进方向
            int r = 0, c = 0, di = 0;

            for (int i = 0; i < R * C; i++) {
                res.add(matrix[r][c]);
                // 记录是否走过了
                seen[r][c] = true;
                int cr = r + dr[di];
                int cc = c + dc[di];
                if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
                    r = cr;
                    c = cc;
                } else {
                    di = (di + 1) % 4;
                    r += dr[di];
                    c += dc[di];
                }
            }
            return res;
        }
    }
}
