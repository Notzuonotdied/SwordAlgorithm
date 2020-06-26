package LeetCode.Java;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(Solution1.subsets(new int[]{1, 2, 3}));
    }

    private static class Solution1 {
        /**
         * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
         * <p>
         * 说明：解集不能包含重复的子集。
         * <p>
         * 题解思路：使用位掩码的方式处理子集的生成问题。
         * <p>
         * 题解：https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode/
         */
        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> output = new ArrayList<>();
            int n = nums.length;

            for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
                List<Integer> curr = new ArrayList<>();
                int temp = i;
                for (int num : nums) {
                    if ((temp & 1) == 1) {
                        curr.add(num);
                    }
                    temp = temp >> 1;
                }
                output.add(curr);
            }
            return output;
        }
    }
}
