package LeetCode.Java;

import java.util.Arrays;

public class GenerateMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(Solution1.generateMatrix(3)));
    }

    private static class Solution1 {
        public static int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            if (n == 0) {
                return res;
            }
            boolean[][] status = new boolean[n][n];

            int count = 1;
            // 判断当前方向的计算方式
            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};
            // di是前进方向
            int r = 0, c = 0, di = 0;

            for (int i = 0; i < n * n; i++) {
                res[r][c] = count++;
                // 记录是否走过了
                status[r][c] = true;
                int cr = r + dr[di];
                int cc = c + dc[di];
                if (0 <= cr && cr < n && 0 <= cc && cc < n && !status[cr][cc]) {
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
