package LeetCode.Java.array;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 2, 6, 3, 1};
        new Solution1().nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }

    private static class Solution1 {

        /**
         * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
         * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
         * 必须 原地 修改，只允许使用额外常数空间。
         * <p>
         * 题解：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/next-permutation
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * <p>
         * 执行用时：1 ms, 在所有 Java 提交中击败了98.29% 的用户
         * 内存消耗：38.4 MB, 在所有 Java 提交中击败了91.90% 的用户
         */
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                // 这里使用j>=0也是对的
                // 因为i找的是相对最小数，而j是从i右边从右向左找第一个比i大的数
                while (j >= i && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }
}
