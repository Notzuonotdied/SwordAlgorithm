package SwordOffer.JavaOffer;

public class Demo28 {
    public static void main(String[] args) {
        System.out.println(Solution1.MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    private static class Solution1 {

        public static int MoreThanHalfNum_Solution(int[] array) {
            // 判断是否为空
            if (array == null || array.length == 0) {
                return 0;
            }

            // 使用一个基准，统计数量
            int preValue = array[0];
            // 初始为1
            int count = 1;
            for (int i = 1; i < array.length; ++i) {
                if (preValue == array[i]) {
                    ++count;
                } else {
                    --count;
                    // 如果计数count为0，则重置数值
                    if (count == 0) {
                        preValue = array[i];
                        count = 1;
                    }
                }
            }

            int num = 0;
            for (int value : array) {
                if (value == preValue) {
                    num++;
                }
            }
            // 判断是否大于数组数量的一半
            return (num > (array.length / 2)) ? preValue : 0;
        }
    }
}
