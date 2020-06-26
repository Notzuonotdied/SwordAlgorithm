package SwordOffer.JavaOffer;

import java.util.Arrays;

public class Demo9 {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(10));
    }

    /**
     * 问题解析：https://blog.csdn.net/friendbkf/article/details/50060239
     */
    public static int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }
}
