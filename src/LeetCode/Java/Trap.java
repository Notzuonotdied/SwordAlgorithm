package LeetCode.Java;

public class Trap {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
         * <p>
         * 使用韦恩图法解决：
         * * https://leetcode-cn.com/problems/trapping-rain-water/solution/wei-en-tu-jie-fa-zui-jian-dan-yi-dong-10xing-jie-j/
         */
        public int trap(int[] height) {
            int n = height.length;
            int sum = 0;

            int s1 = 0;
            int s2 = 0;

            int max1 = 0;
            int max2 = 0;

            for (int i = 0; i < n; ++i) {
                if (height[i] > max1) {
                    max1 = height[i];
                }
                if (height[n - i - 1] > max2) {
                    max2 = height[n - i - 1];
                }
                s1 += max1;
                s2 += max2;

                sum += height[i];
            }

            return s1 + s2 - max1 * n - sum;
        }
    }
}
