package LeetCode.Java;

public class SearchInsert {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
         * <p>
         * 你可以假设数组中无重复元素。
         * <p>
         * 输入: [1,3,5,6], 5
         * 输出: 2
         * <p>
         * 地址：https://leetcode-cn.com/problems/search-insert-position/
         */
        public int searchInsert(int[] nums, int target) {
            if (nums.length == 0 || nums[0] > target) {
                return 0;
            }
            if (nums[nums.length - 1] < target) {
                return nums.length;
            }

            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return left;
        }
    }
}
