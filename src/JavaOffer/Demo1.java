package JavaOffer;

import java.util.Random;

public class Demo1 {

    /**
     * 查找二维数组中的元素
     *
     * @param matrix 待查询的数组
     * @param number 查询的数字
     */
    public static boolean Find(int number, int[][] matrix) {
        // 输入条件判断
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = matrix.length; // 数组的行数
        int cols = matrix[1].length; // 数组行的列数

        int row = 0; // 起始开始的行号
        int col = cols - 1; // 起始开始的列号

        // 要查找的位置确保在数组之内
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            // 如果找到了就直接退出
            if (matrix[row][col] == number) {
                System.out.println("找到啦～" + number + " -> (" + row + ", "
                        + col + ")");
                return true;
            }
            // 如果找到的数比要找的数大，说明要找的数在当前数的左边
            else if (matrix[row][col] > number) {
                // 列数减一，代表向左移动
                col--;
            }
            // 如果找到的数比要找的数小，说明要找的数在当前数的下边
            else {
                // 行数加一，代表向下移动
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int line = 10;
        int column = 10;
        int[][] test = new int[line][column];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                test[i][j] = i * column + j;
            }
        }
        Random random = new Random();
        int number = random.nextInt(line * column);
        System.out.println("寻找的数字为：" + number);
        if (Find(number, test)) {
            System.out.println("找到啦");
        } else {
            System.out.println("没有找到");
        }
    }
}
