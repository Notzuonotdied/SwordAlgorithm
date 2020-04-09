package LeetCode.Java;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(Solution1.climbStairs(3));
        System.out.println(Solution2.climbStairs(3));

        for (int i = 3; i < 10; ++i) {
            if (Solution1.climbStairs(i) != Solution2.climbStairs(i)) {
                System.out.println("i = " + i + " 结果出错了。");
                System.out.println("Solution1 = " + Solution1.climbStairs(i) + " Solution2 = " + Solution2.climbStairs(i));
            }
        }
    }

    private static class Solution1 {
        /**
         * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
         * <p>
         * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
         * <p>
         * 注意：给定 n 是一个正整数。
         * <p>
         * https://leetcode-cn.com/problems/climbing-stairs/
         */
        public static int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }

            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; ++i) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    private static class Solution2 {
        /**
         * 使用递归，超时了……
         */
        public static int climbStairs(int n) {
            if (n <= 1) {
                return 1;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
