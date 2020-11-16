package LeetCode.Java.backtrace;

import java.util.List;
import java.util.ArrayList;

public class Permute {
    public static void main(String[] args) {
        System.out.println(Solution1.permute(new int[]{1, 2, 3}));
    }

    private static class Solution1 {

        /**
         * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
         * <p>
         * https://leetcode-cn.com/problems/permutations/
         */
        public static List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0) {
                return new ArrayList<>();
            }

            List<List<Integer>> result = new ArrayList<>();

            int[] visited = new int[nums.length];

            backtrack(result, nums, new ArrayList<>(), visited);
            return result;
        }

        private static void backtrack(List<List<Integer>> result, int[] nums, ArrayList<Integer> integers, int[] visited) {
            if (integers.size() == nums.length) {
                result.add(new ArrayList<>(integers));
                return;
            }

            for (int i = 0; i < nums.length; ++i) {
                if (visited[i] == 1) {
                    continue;
                }
                visited[i] = 1;
                integers.add(nums[i]);
                backtrack(result, nums, integers, visited);
                visited[i] = 0;
                integers.remove(integers.size() - 1);
            }
        }
    }
}
