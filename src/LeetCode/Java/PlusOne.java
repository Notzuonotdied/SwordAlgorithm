package LeetCode.Java;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution1.plusOne(new int[]{0})));
        System.out.println(Arrays.toString(Solution1.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(Solution1.plusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(Solution1.plusOne(new int[]{9, 9, 9})));
    }

    private static class Solution1 {
        /**
         * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
         * <p>
         * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
         * <p>
         * 你可以假设除了整数 0 之外，这个整数不会以零开头。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/plus-one
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        public static int[] plusOne(int[] digits) {
            if (digits.length == 0) {
                return digits;
            }

            int right = digits.length - 1;
            while (right >= 0) {
                if (digits[right] < 9) {
                    digits[right] += 1;
                    break;
                } else {
                    digits[right] = 0;
                    right--;
                }
            }
            // 数据溢出
            if (right == -1 && digits[0] == 0) {
                int[] result = new int[digits.length + 1];
                int i = 0;
                result[i++] = 1;
                for (int num : digits) {
                    result[i++] = num;
                }
                return result;
            }
            return digits;
        }
    }
}
