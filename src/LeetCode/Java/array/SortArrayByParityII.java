package LeetCode.Java.array;

public class SortArrayByParityII {

    public static void main(String[] args) {

    }

    private interface ISolution {
        int[] sortArrayByParityII(int[] nums);
    }

    private static class Solution1 implements ISolution {

        /**
         * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
         * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
         * 你可以返回任何满足上述条件的数组作为答案。
         * 示例：
         * 输入：[4,2,5,7]
         * 输出：[4,5,2,7]
         * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        @Override
        public int[] sortArrayByParityII(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];

            int i = 0;
            for (int x : nums) {
                if (x % 2 == 0) {
                    ans[i] = x;
                    i += 2;
                }
            }
            i = 1;
            for (int x : nums) {
                if (x % 2 == 1) {
                    ans[i] = x;
                    i += 2;
                }
            }
            return ans;
        }
    }

    private static class Solution2 implements ISolution {

        /**
         * 执行用时：2 ms, 在所有 Java 提交中击败了98.38% 的用户
         * 内存消耗：39.3 MB, 在所有 Java 提交中击败了92.99% 的用户
         */
        public int[] sortArrayByParityII(int[] nums) {
            int n = nums.length;
            int j = 1;
            for (int i = 0; i < n; i += 2) {
                if (nums[i] % 2 == 1) {
                    while (nums[j] % 2 == 1) {
                        j += 2;
                    }
                    swap(nums, i, j);
                }
            }
            return nums;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
