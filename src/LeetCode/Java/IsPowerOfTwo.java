package LeetCode.Java;

public class IsPowerOfTwo {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
         * <p>
         * https://leetcode-cn.com/problems/power-of-two/
         * <p>
         * 题解：https://leetcode-cn.com/problems/power-of-two/solution/2de-mi-by-leetcode/
         */
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
