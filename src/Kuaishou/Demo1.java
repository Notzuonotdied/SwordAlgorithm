package Kuaishou;

public class Demo1 {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/003482c395bd41c68082f6adc545a600?answerType=1&f=discussion
     * 来源：牛客网
     * <p>
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * ("回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。)
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
     * 可用C++,Java,C#实现相关代码逻辑
     */
    public static void main(String[] args) {
        // 使用动态规划解决
        System.out.println(Solution1.dp("aabcb"));
    }

    /**
     * https://www.nowcoder.com/practice/003482c395bd41c68082f6adc545a600
     */
    private static class Solution1 {
        /**
         * 使用动态规划解题，找出方程：
         * <p>
         * 假如字符串为「aaaaa」
         * 第一次查找：axxxa，由于收尾相等，均为a，因此需要判断内部的子串是否为回文串「xxx」，
         * 第二次查找：axa，由于子串长度为(3-1+1=3)，为3个的时候只需要首尾相同即为回文数，因此有j - i + 1 <= 3
         * 123
         * <p>
         * aabcb
         * <p>
         * / a a b c b
         * a 1 1 0 0 0
         * a 0 1 0 0 0
         * b 0 0 1 0 1
         * c 0 0 0 1 0
         * b 0 0 0 0 1
         *
         * @param s 输入数据
         */
        private static int dp(String s) {
            int n = s.length(), ans = 0;
            boolean[][] dp = new boolean[n][n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1]);
                    if (dp[i][j]) ans++;
                }
            }

//        for (int i = 0; i < n; ++i) {
//            StringBuilder sb = new StringBuilder();
//            if (i == 0) {
//                sb.append(" ").append(" ");
//                for (int j = 0; j < n; ++j) {
//                    sb.append(j).append(" ");
//                }
//                sb.append("\n");
//            }
//            for (int j = 0; j < n; ++j) {
//                if (j == 0) {
//                    sb.append(i).append(" ");
//                }
//                sb.append(dp[i][j] ? 1 : 0).append(" ");
//            }
//            System.out.println(sb.toString());
//        }

            return ans;
        }
    }
}
