package LeetCode.Java;

public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(Solution1.myAtoi("4193 with words")); // 4193
        System.out.println(Solution1.myAtoi("words and 987")); // 0
        System.out.println(Solution1.myAtoi("-91283472332")); // -2147483648
        System.out.println(Solution1.myAtoi(" -42")); // -42
    }

    private static class Solution1 {
        public static int myAtoi(String str) {
            int length = str.length();
            char[] chars = str.toCharArray();

            int idx = 0;
            while (idx < length && chars[idx] == ' ') {
                idx++;
            }
            if (idx == length) {
                return 0;
            }

            int prefix = chars[idx];
            boolean negative = prefix == '-';
            if (prefix == '-' || prefix == '+') {
                idx++;
            }

            int ans = 0;
            while (idx < length) {
                // 原来的数字
                int digit = chars[idx++] - '0';
                if (digit < 0 || digit > 9) {
                    break;
                }
                // 是有符号整数，而且
                if (ans > (Integer.MAX_VALUE - digit) / 10) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = ans * 10 + digit;
            }
            return negative ? -ans : ans;
        }
    }
}
