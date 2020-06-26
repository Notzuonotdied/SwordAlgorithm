package LeetCode.Java.offer;

/**
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 *
 * 示例：
 *
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 *
 * 提示：
 *
 *     numbers.length == 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-numbers-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapNumbers {
    public static void main(String[] args) {

    }

    private static class Solution3 {
        /**
         * 使用异或
         */
        public int[] swapNumbers(int[] numbers) {
            numbers[0] ^= numbers[1];
            numbers[1] ^= numbers[0];
            numbers[0] ^= numbers[1];
            return numbers;
        }
    }

    private static class Solution2 {
        /**
         * 使用减法
         */
        public int[] swapNumbers(int[] numbers) {
            numbers[0] = numbers[0] - numbers[1];
            numbers[1] = numbers[0] + numbers[1];
            numbers[0] = numbers[1] - numbers[0];
            return numbers;
        }
    }

    private static class Solution1 {
        /**
         * 使用加法
         */
        public int[] swapNumbers(int[] numbers) {
            numbers[0] = numbers[0] + numbers[1];
            numbers[1] = numbers[0] - numbers[1];
            numbers[0] = numbers[0] - numbers[1];
            return numbers;
        }
    }
}
