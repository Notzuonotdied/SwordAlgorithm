package LeetCode.Java.array;

import java.util.Arrays;

public class MergeOrderlyArray {
    public static void main(String[] args) {
        test(new Solution1());
    }

    private static void test(IMerge iMerge) {
        int[] array1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] array2 = new int[]{2, 5, 6};
        iMerge.merge(array1, 3, array2, array2.length);
        System.out.println(Arrays.toString(array1));

        array1 = new int[]{4, 5, 6, 0, 0, 0};
        array2 = new int[]{1, 2, 3};
        iMerge.merge(array1, 3, array2, array2.length);
        System.out.println(Arrays.toString(array1));

        array1 = new int[]{1, 2, 0, 0, 0, 0};
        array2 = new int[]{4, 5, 6, 7};
        iMerge.merge(array1, 2, array2, array2.length);
        System.out.println(Arrays.toString(array1));
    }

    private interface IMerge {
        void merge(int[] nums1, int m, int[] nums2, int n);
    }

    private static class Solution1 implements IMerge {
        /**
         * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
         * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
         * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
         * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/merge-sorted-array
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * nums1 = [1,2,3,0,0,0], m = 3
         * nums2 = [2,5,6],       n = 3
         * <p>
         * nums1 = [4,5,6,1,2,3], m = 3
         * nums2 = [1,2,3],       n = 3
         * <p>
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：38.6 MB, 在所有 Java 提交中击败了16.53% 的用户
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int len1 = m - 1;
            int len2 = n - 1;

            int len = m + n - 1;
            while (len1 >= 0 && len2 >= 0) {
                nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
            }
            // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
            System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
        }
    }
}
