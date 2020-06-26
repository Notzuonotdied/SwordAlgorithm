package LeetCode.Java.matrix;

import java.util.Arrays;

public class FindDiagonalOrder {
    public static void main(String[] args) {
        // [1,2,4,7,5,3,6,8,9]
        // System.out.println(Arrays.toString(Solution1.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        // [2,5,8,0,4,-1]
        System.out.println(Arrays.toString(Solution1.findDiagonalOrder(new int[][]{{2, 5}, {8, 4}, {0, -1}})));
    }

    private static class Solution1 {
        /**
         * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素。
         * <p>
         * 输入:
         * [
         * [ 1, 2, 3 ],
         * [ 4, 5, 6 ],
         * [ 7, 8, 9 ]
         * ]
         * <p>
         * 输出:  [1,2,4,7,5,3,6,8,9]
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/diagonal-traverse
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 根据以下思路实现：
         *      执行用时 :2 ms, 在所有 Java 提交中击败了97.93% 的用户
         *      内存消耗 :42.2 MB, 在所有 Java 提交中击败了73.33%的用户
         *
         * <p>
         * 每层的索引和相等：
         * 1. 假设矩阵无限大；
         * 2. 索引和为{偶}数，向上遍历，{横}索引值递减，遍历值依次是(x,0),(x-1,1),(x-2,2),...,(0,x)
         * 3. 索引和为{奇}数，向下遍历，{纵}索引值递减，遍历值依次是(0,y),(1,y-1),(2,y-2),...,(y,0)
         * <p>
         *        每层的索引和:
         *             0:              (00)
         *             1:            (01)(10)
         *             2:          (20)(11)(02)
         *             3:        (03)(12)(21)(30)
         *             4:      (40)(31)(22)(13)(04)
         *             5:    (05)(14)(23)(32)(41)(50)
         *             6:  (60)(51)................(06)
         *
         *         按照“层次”遍历，依次append在索引边界内的值即可
         * <p>
         * 按照“层次”遍历，依次append在索引边界内的值即可
         * <p>
         * 原链接：https://leetcode-cn.com/problems/diagonal-traverse/comments/40157
         */
        public static int[] findDiagonalOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return new int[0];
            }
            int row = matrix.length;
            int column = matrix[0].length;
            // 结果
            int index = 0;
            int[] result = new int[column * row];
            // 层数
            int loop = 0;
            int i, j;
            // 总的遍历次数刚好是row+column-1
            while (loop < row + column - 1) {
                if (loop % 2 == 0) {
                    // 当经过副对角线后，呈收敛状态，第一个i应该以row-1为边界
                    for (i = Math.min(loop, row - 1); i >= 0; i--) {
                        j = loop - i;
                        if (j >= column) {
                            break;
                        }
                        result[index++] = matrix[i][j];
                    }
                } else {
                    // 当经过副对角线后，呈收敛状态，第一个i应该以column-1为边界
                    for (j = Math.min(loop, column - 1); j >= 0; j--) {
                        i = loop - j;
                        if (i >= row) {
                            break;
                        }
                        result[index++] = matrix[i][j];
                    }
                }
                loop++;
            }
            return result;
        }
    }
}
