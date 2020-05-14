package LeetCode.Java.dp;

public class WaysToStep {
    public static void main(String[] args) {
        System.out.println(Solution1.waysToStep(76));
    }

    private static class Solution1 {
        /**
         * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
         * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
         */
        public static int waysToStep(int n) {
            long[] dp = new long[3];

            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 4;

            if (n < 3) {
                return (int) dp[n - 1];
            }

            int index = 3;
            while (index < n) {
                dp[index % 3] = (dp[0] + dp[1] + dp[2]) % 1000000007;
                index++;
            }
            return (int) dp[(index - 1) % 3];
        }
    }
}
