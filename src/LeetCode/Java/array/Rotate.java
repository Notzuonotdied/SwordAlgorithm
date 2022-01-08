package LeetCode.Java.array;

import java.util.Arrays;

public class Rotate {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        System.out.println(Arrays.deepToString(matrix));
        new Solution1().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static class Solution1 {
    /**
     * 这题目可以直接通过规律推算出来。
     * <p>
     * x |  0   1   2   3
     * ------------------
     * 0 |  5   1   9   11
     * 1 |  2   4   8   10
     * 2 |  13  3   6   7
     * 3 |  15  14  12  16
     * <p>
     * 旋转过程1：(2, 0) => (0, 1)
     * 旋转过程2：(0, 1) => (1, 3)
     * 旋转过程3：(1, 3) => (3, 2)
     * 旋转过程4：(3, 2) => (2, 0)
     * <p>
     * 对应推导：
     * * 二维数组的len = 4
     * * 定义i是外循环次数：i = len / 2 = 2（两圈）
     * * 定义j是内循环次数：j = len - i - 1（示例中：最外圈需要移动3次，最内圈需要移动1次）
     * <p>
     * 以下定义i = 0，j = 1
     * <p>
     * 旋转过程1：(len - j - i, i) => (i, j)
     * 旋转过程2：(i, j) => (j, len - i - 1)
     * 旋转过程3：(j, len - i - 1) => (len - i - 1, len - j - 1)
     * 旋转过程4：(len - i - 1, len - j - 1) => (len - j - 1, i)
     *
     * <p>
     * 题解：https://leetcode-cn.com/problems/rotate-image/solution/shu-ju-jie-gou-he-suan-fa-liang-chong-sh-k3dy/
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        // 矩阵是对称的，仅仅需要处理一半的长度
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                int temp = matrix[i][j];
                int m = len - j - 1;
                int n = len - i - 1;
                matrix[i][j] = matrix[m][i];
                matrix[m][i] = matrix[n][m];
                matrix[n][m] = matrix[j][n];
                matrix[j][n] = temp;
            }
        }
    }
    }
}
