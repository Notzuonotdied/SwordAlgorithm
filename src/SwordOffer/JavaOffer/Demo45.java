package SwordOffer.JavaOffer;

import java.util.Arrays;

public class Demo45 {

    public static void main(String[] args) {

    }

    public static class Solution1 {
        /**
         * 1、排序
         * 2、计算所有相邻数字间隔总数
         * 3、计算0的个数
         * 4、如果2、3相等，就是顺子
         * 5、如果出现对子，则不是顺子
         */
        public static boolean isContinuous(int[] numbers) {
            int numOfZero = 0;
            int numOfInterval = 0;
            int length = numbers.length;
            if (length == 0) {
                return false;
            }
            Arrays.sort(numbers);
            for (int i = 0; i < length - 1; i++) {
                // 计算癞子数量
                if (numbers[i] == 0) {
                    numOfZero++;
                    continue;
                }
                // 对子，直接返回
                if (numbers[i] == numbers[i + 1]) {
                    return false;
                }
                numOfInterval += numbers[i + 1] - numbers[i] - 1;
            }
            return numOfZero >= numOfInterval;
        }
    }
}
