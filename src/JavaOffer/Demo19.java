package JavaOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo19 {

    public static void main(String[] args) {
        // 1, 2, 3, 4
        // 5, 6, 7, 8
        // 9,10,11,12
        ArrayList<Integer> lists = printMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        System.out.println(Arrays.toString(lists.toArray()));
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        // 输入的参数不能为空
        if (matrix == null) {
            return null;
        }

        // 记录一圈（环）的开始位置的行
        int x = 0;
        // 记录一圈（环）的开始位置的列
        int y = 0;

        ArrayList<Integer> list = new ArrayList<>();

        // 对每一圈（环）进行处理，
        // 行号最大是(numbers.length-1)/2
        // 列号最大是(numbers[0].length-1)/2
        while (x * 2 < matrix.length && y * 2 < matrix[0].length) {
            list.addAll(printMatrixInCircle(matrix, x, y));
            // 指向下一个要处理的的环的第一个位置
            x++;
            y++;
        }

        return list;
    }

    private static ArrayList<Integer> printMatrixInCircle(int[][] numbers, int x, int y) {
        ArrayList<Integer> list = new ArrayList<>();

        // 数组的行数
        int rows = numbers.length;
        // 数组的列数
        int cols = numbers[0].length;

        // 输出环的上面一行，包括最中的那个数字
        for (int i = y; i <= cols - y - 1; i++) {
            list.add(numbers[x][i]);
        }

        // 环的高度至少为2才会输出右边的一列
        // rows-x-1：表示的是环最下的那一行的行号
        if (rows - x - 1 > x) {
            // 因为右边那一列的最上面那一个已经被输出了，所以行呈从x+1开始，
            // 输出包括右边那列的最下面那个
            for (int i = x + 1; i <= rows - x - 1; i++) {
                list.add(numbers[i][cols - y - 1]);
            }
        }

        // 环的高度至少是2并且环的宽度至少是2才会输出下面那一行
        // cols-1-y：表示的是环最右那一列的列号
        if (rows - x - 1 > x && cols - 1 - y > y) {
            // 因为环的左下角的位置已经输出了，所以列号从cols-y-2开始
            for (int i = cols - y - 2; i >= y; i--) {
                list.add(numbers[rows - 1 - x][i]);
            }
        }

        // 环的宽度至少是2并且环的高度至少是3才会输出最左边那一列
        // rows-x-1：表示的是环最下的那一行的行号
        if (cols - 1 - y > y && rows - 1 - x > x + 1) {
            // 因为最左边那一列的第一个和最后一个已经被输出了
            for (int i = rows - 1 - x - 1; i >= x + 1; i--) {
                list.add(numbers[i][y]);
            }
        }

        return list;
    }


}
