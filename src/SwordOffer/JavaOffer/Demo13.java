package SwordOffer.JavaOffer;

import java.util.Arrays;

public class Demo13 {

    public static void main(String[] args) {
        reOrderArray(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    public static void reOrderArray(int[] array) {
        int j = 0;// 记录第一个为奇数的位置
        int m = 0;// 记录排好序的奇数的最后一个位置
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {// 找到第一个奇数
                int temp = array[i];// 记录第一个奇数
                int ti = i;
                for (; ti > 0; ti--) {
                    array[ti] = array[ti - 1];// 将第一个奇数之前的所有元素往后移一个位置
                }
                array[0] = temp;// 将第一个奇数放到array[0]位置
                j = i;
                break;
            }
        }
        for (++j; j < array.length; j++) { // 依次寻找剩余的奇数
            if (array[j] % 2 == 1) {
                int temp = array[j];
                int tj = j;
                for (; tj > m; tj--) {
                    array[tj] = array[tj - 1];
                }
                array[++m] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}