package LeetCode.Java;

public class PalindromeNumber {
    public static void main(String[] args) {

    }

    private static class Solution {
        /**
         * 反转数字对比即可
         */
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) return false;
            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x /= 10;
            }
            // 奇数 || 偶数
            return x == revertedNumber || x == revertedNumber / 10;
        }
    }
}
