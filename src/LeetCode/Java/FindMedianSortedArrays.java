package LeetCode.Java;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    private static class Solution1 {
        /**
         * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
         * <p>
         * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
         * <p>
         * 你可以假设 nums1 和 nums2 不会同时为空。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 【Java视频讲解系列】Median of two sorted arrays
         * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/javashi-pin-jiang-jie-xi-lie-median-of-two-sorted-/
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 核心思路：将问题转换为寻找第K个数
            int sum = nums1.length + nums2.length;
            if (sum % 2 == 0) {
                return ((double) findKth(nums1, 0, nums2, 0, sum / 2) +
                        (double) findKth(nums1, 0, nums2, 0, sum / 2 + 1)) / 2;
            }
            return findKth(nums1, 0, nums2, 0, (sum + 1) / 2);
        }

        private int findKth(int[] nums1, int left1, int[] nums2, int left2, int k) {
            if (left1 >= nums1.length) {
                return nums2[left2 + k - 1];
            }
            if (left2 >= nums2.length) {
                return nums1[left1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[left1], nums2[left2]);
            }
            int mid1 = left1 + k / 2 - 1 < nums1.length ? nums1[left1 + k / 2 - 1] : Integer.MAX_VALUE;
            int mid2 = left2 + k / 2 - 1 < nums2.length ? nums2[left2 + k / 2 - 1] : Integer.MAX_VALUE;
            if (mid1 <= mid2) {
                return findKth(nums1, left1 + k / 2, nums2, left2, k - k / 2);
            }
            return findKth(nums1, left1, nums2, left2 + k / 2, k - k / 2);
        }
    }
}
