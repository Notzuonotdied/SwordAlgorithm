package LeetCode.Java.array;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 3, 4, 5, 6};
        // 答案是[2, 4]
        System.out.println(Arrays.toString(new Solution1().searchRange(array, 3)));
    }

    private static class Solution1 {

        /**
         * 范围搜索。
         * 题解：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：41.4 MB, 在所有 Java 提交中击败了94.58% 的用户
         *
         * @param nums   待搜索的数组
         * @param target 目标字段
         */
        public int[] searchRange(int[] nums, int target) {
            // 低位搜索
            int leftIdx = binarySearch(nums, target, true);
            // 高位搜索(搜索比target大的位置，所以需要-1)
            int rightIdx = binarySearch(nums, target, false) - 1;
            // 校验找到的索引是否符合
            if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
                return new int[]{leftIdx, rightIdx};
            }
            // 找到的索引不符合，返回默认值
            return new int[]{-1, -1};
        }

        /**
         * 二分搜索模板
         *
         * @param nums   待搜索的数组
         * @param target 目标字段
         * @param lower  是否是低位搜索（二分查找的时候，遇到target时，往高位搜索还是往低位搜索）
         */
        private int binarySearch(int[] nums, int target, boolean lower) {
            int left = 0, right = nums.length - 1, ans = nums.length;
            int mid;
            while (left <= right) {
                mid = (left + right) >> 1;
                // lower表示低位搜索
                if (nums[mid] > target || (lower && nums[mid] >= target)) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }
}
