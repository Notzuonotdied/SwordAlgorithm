package LeetCode.Java;

import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(Solution1.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    private static class Solution1 {
        /**
         * 给定一个整数数组，判断是否存在重复元素。
         * <p>
         * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
         * <p>
         * https://leetcode-cn.com/problems/contains-duplicate/
         */
        public static boolean containsDuplicate(int[] nums) {
            if (nums.length == 0) {
                return false;
            }

            Set<Integer> numsMap = new HashSet<>();
            for (int num : nums) {
                if (numsMap.contains(num)) {
                    return true;
                }
                numsMap.add(num);
            }

            return false;
        }
    }
}
