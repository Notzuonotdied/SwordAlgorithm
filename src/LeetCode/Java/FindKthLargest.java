package LeetCode.Java;

public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println(Solution1.findKthLargest(new int[]{-1, 2, 0}, 1));
    }

    private static class Solution1 {
        /**
         * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
         * <p>
         * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
         *
         * @see BaseAlgorithm.Java.QuickSort 利用了快排的思路
         * @see SwordOffer.JavaOffer.Demo29             利用快排找最小的第 K 个元素
         */
        public static int findKthLargest(int[] nums, int k) {
            int index = 0;
            int start = 0;
            int end = nums.length - 1;

            while (start <= end) {
                index = partition(nums, start, end);

                if (index == k - 1) {
                    break;
                } else if (index < k - 1) {
                    start = index + 1;
                } else {
                    end = index - 1;
                }
            }

            return nums[index];
        }

        private static int partition(int[] nums, int start, int end) {
            int privot = nums[start];

            while (start < end) {
                while (start < end && nums[end] <= privot) {
                    end--;
                }
                swap(nums, start, end);
                while (start < end && nums[start] >= privot) {
                    start++;
                }
                swap(nums, start, end);
            }
            return start;
        }

        private static void swap(int[] nums, int start, int j) {
            int temp = nums[start];
            nums[start] = nums[j];
            nums[j] = temp;
        }

    }
}
