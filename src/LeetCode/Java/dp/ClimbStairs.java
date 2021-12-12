package LeetCode.Java.dp;

public class ClimbStairs {
    public static void main(String[] args) {
        int i = 10;
        System.out.println(new Solution1().climbStairs(i));
        System.out.println(new Solution2().climbStairs(i));
        System.out.println(new Solution3().climbStairs(i));
    }

    private interface IClimbStairs {

        int climbStairs(int n);
    }

    private static class Solution1 implements IClimbStairs {
        /**
         * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
         * <p>
         * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
         * <p>
         * 注意：给定 n 是一个正整数。
         * <p>
         * https://leetcode-cn.com/problems/climbing-stairs/
         */
        @Override
        public int climbStairs(int n) {
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

    private static class Solution2 implements IClimbStairs {
        /**
         * 使用递归，超时了……
         */
        @Override
        public int climbStairs(int n) {
            if (n <= 1) {
                return 1;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    private static class Solution3 implements IClimbStairs {

        /**
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：34.7 MB, 在所有 Java 提交中击败了99.07% 的用户
         */
        @Override
        public int climbStairs(int n) {
            if (n < 2) {
                return n;
            } else if (n == 2) {
                return 2;
            }
            int tmp = 0;
            // 省内存版本
            int[] dp = new int[2];
            dp[0] = 2;
            dp[1] = 1;
            for (int i = 3; i <= n; ++i) {
                tmp = i % 2;
                dp[tmp] = dp[0] + dp[1];
            }
            return dp[tmp];
        }
    }
}
